package com.smartling.connector.exacttarget.sdk.client;

import com.smartling.connector.exacttarget.sdk.Configuration;
import com.smartling.connector.exacttarget.sdk.data.AuthData;
import com.smartling.connector.exacttarget.sdk.data.AuthWithRefreshTokenData;
import com.smartling.connector.exacttarget.sdk.data.TokenInfo;
import com.smartling.connector.exacttarget.sdk.rest.api.LoginApi;
import org.apache.commons.lang3.StringUtils;

import static com.smartling.connector.exacttarget.sdk.client.ApiClient.buildApi;

public class LoginClient
{
    private final LoginApi loginApi;
    private final Configuration configuration;

    public LoginClient(final Configuration configuration)
    {
        this.configuration = configuration;
        this.loginApi = buildApi(LoginApi.class, ApiClient.BASE_AUTH_API_URL, configuration);
    }

    public TokenInfo getTokenInfo()
    {
        if (StringUtils.isEmpty(configuration.getRefreshToken()))
        {
            return loginApi.getTokenInfo(new AuthData(configuration.getUsername(), configuration.getPassword()));
        }
        else
        {
            return loginApi.getTokenInfo(new AuthWithRefreshTokenData(configuration.getUsername(), configuration.getPassword(), "offline", configuration.getRefreshToken()));
        }
    }
}
