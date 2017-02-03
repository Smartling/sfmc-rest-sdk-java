package com.smartling.connector.exacttarget.sdk.client;

import com.smartling.connector.exacttarget.sdk.Configuration;
import com.smartling.connector.exacttarget.sdk.data.AuthWithRefreshTokenData;
import com.smartling.connector.exacttarget.sdk.rest.api.LoginApi;

public class LoginClient
{
    private Configuration configuration;
    private final LoginApi loginApi;
    public static final String BASE_AUTH_API_URL = "https://auth.exacttargetapis.com";

    public LoginClient(final Configuration configuration)
    {
        this.configuration = configuration;
        this.loginApi = ApiClient.buildApi(LoginApi.class, BASE_AUTH_API_URL, configuration);
    }

    public String getRefreshToken()
    {
        return loginApi.getTokenInfo(new AuthWithRefreshTokenData(configuration.getUsername(), configuration.getPassword(), "offline", configuration.getRefreshToken())).getRefreshToken();
    }
}
