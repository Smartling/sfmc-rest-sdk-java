package com.smartling.connector.eloqua.sdk.client;

import com.smartling.connector.eloqua.sdk.Configuration;
import com.smartling.connector.eloqua.sdk.OAuthRequestInterceptor;
import com.smartling.connector.eloqua.sdk.data.AuthData;
import com.smartling.connector.eloqua.sdk.data.TokenInfo;
import com.smartling.connector.eloqua.sdk.rest.api.LoginApi;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.slf4j.LoggerFactory;

public abstract class ApiClient
{
    private Configuration configuration;
    private final LoginApi loginApi;
    private final TokenInfo tokenInfo;
    public static final String BASE_AUTH_API_URL = "https://auth.exacttargetapis.com";
    public static final String BASE_API_URL = "https://www.exacttargetapis.com";
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ApiClient.class);

    public ApiClient(final Configuration configuration)
    {
        this.configuration = configuration;
        this.loginApi = buildApi(LoginApi.class, BASE_AUTH_API_URL);
        this.tokenInfo = loginApi.getTokenInfo(new AuthData(configuration.getUsername(), configuration.getPassword()));
    }

    private <A> A buildApi(final Class<A> apiClass, final String apiBaseUrl)
    {
        return Feign.builder()
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .errorDecoder(new SFCMRestErrorDecoder())
                    .options(configuration.getOptions())
                    .logger(new Logger.JavaLogger().appendToFile("logs/http.log"))
                    .logLevel(Logger.Level.FULL)
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
                    .logger(new Logger.JavaLogger().appendToFile("logs/http.log"))
                    .logLevel(Logger.Level.FULL)
                    .target(apiClass, apiBaseUrl);
    }
}
