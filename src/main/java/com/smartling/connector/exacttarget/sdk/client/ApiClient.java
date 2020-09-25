package com.smartling.connector.exacttarget.sdk.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.smartling.connector.exacttarget.sdk.Configuration;
import com.smartling.connector.exacttarget.sdk.OAuthRequestInterceptor;
import com.smartling.connector.exacttarget.sdk.data.TokenInfo;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public abstract class ApiClient
{
    public static final String V1_AUTH_API_URL = "https://auth.exacttargetapis.com";
    public static final String V1_API_URL = "https://www.exacttargetapis.com";

    private Configuration configuration;
    private final TokenInfo tokenInfo;

    public ApiClient(final Configuration configuration, TokenInfo tokenInfo)
    {
        this.configuration = configuration;
        this.tokenInfo = tokenInfo;
    }

    static <A> A buildApi(final Class<A> apiClass, final String apiBaseUrl, final Configuration configuration)
    {
        ObjectMapper om = getObjectMapper();
        return Feign.builder()
                    .encoder(new JacksonEncoder(om))
                    .decoder(new JacksonDecoder(om))
                    .errorDecoder(new SFCMRestErrorDecoder())
                    .options(configuration.getOptions())
                    .target(apiClass, apiBaseUrl);
    }

    protected  <A> A buildApiWithOAuthAuthentication(final Class<A> apiClass, final String apiBaseUrl)
    {
        ObjectMapper om = getObjectMapper();
        return Feign.builder()
                    .requestInterceptor(new OAuthRequestInterceptor(tokenInfo))
                    .encoder(new JacksonEncoder(om))
                    .decoder(new JacksonDecoder(om))
                    .errorDecoder(new SFCMRestErrorDecoder())
                    .options(configuration.getOptions())
                    .target(apiClass, apiBaseUrl);
    }

    public String getValidRefreshToken()
    {
        return tokenInfo.getRefreshToken();
    }

    private static ObjectMapper getObjectMapper()
    {
        return new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
