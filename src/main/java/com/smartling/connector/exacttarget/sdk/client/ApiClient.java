package com.smartling.connector.exacttarget.sdk.client;

import com.smartling.connector.exacttarget.sdk.Configuration;
import com.smartling.connector.exacttarget.sdk.OAuthRequestInterceptor;
import com.smartling.connector.exacttarget.sdk.data.TokenInfo;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.slf4j.LoggerFactory;

public abstract class ApiClient
{
    private Configuration configuration;
    private final TokenInfo tokenInfo;
    public static final String BASE_AUTH_API_URL = "https://auth.exacttargetapis.com";
    public static final String BASE_API_URL = "https://www.exacttargetapis.com";
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ApiClient.class);

    public ApiClient(final Configuration configuration, TokenInfo tokenInfo)
    {
        this.configuration = configuration;
        this.tokenInfo = tokenInfo;
    }

    static <A> A buildApi(final Class<A> apiClass, final String apiBaseUrl, final Configuration configuration)
    {
        return Feign.builder()
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .errorDecoder(new SFCMRestErrorDecoder())
                    .options(configuration.getOptions())
                    .target(apiClass, apiBaseUrl);
    }

    protected  <A> A buildApiWithOAuthAuthentication(final Class<A> apiClass, final String apiBaseUrl)
    {
        return Feign.builder()
                    .requestInterceptor(new OAuthRequestInterceptor(tokenInfo))
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .errorDecoder(new SFCMRestErrorDecoder())
                    .options(configuration.getOptions())
                    .target(apiClass, apiBaseUrl);
    }

    public String getValidRefreshToken()
    {
        return tokenInfo.getRefreshToken();
    }
}
