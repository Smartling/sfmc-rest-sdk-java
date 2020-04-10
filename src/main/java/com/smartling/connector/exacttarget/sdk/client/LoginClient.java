package com.smartling.connector.exacttarget.sdk.client;

import com.smartling.connector.exacttarget.sdk.Configuration;
import com.smartling.connector.exacttarget.sdk.data.TokenInfo;
import com.smartling.connector.exacttarget.sdk.data.auth.v1.AuthDataV1;
import com.smartling.connector.exacttarget.sdk.data.auth.v1.AuthWithRefreshTokenDataV1;
import com.smartling.connector.exacttarget.sdk.data.auth.v1.TokenInfoV1;
import com.smartling.connector.exacttarget.sdk.data.auth.v2.AuthDataV2;
import com.smartling.connector.exacttarget.sdk.data.auth.v2.TokenInfoV2;
import com.smartling.connector.exacttarget.sdk.rest.api.LoginApiV1;
import com.smartling.connector.exacttarget.sdk.rest.api.LoginApiV2;
import org.apache.commons.lang3.StringUtils;

import static com.smartling.connector.exacttarget.sdk.client.ApiClient.buildApi;

public class LoginClient
{
    private final LoginApiV1 loginApiV1;
    private final LoginApiV2 loginApiV2;
    private final Configuration configuration;

    public LoginClient(final Configuration configuration)
    {
        this.configuration = configuration;
        this.loginApiV1 = buildApi(LoginApiV1.class, configuration.getAuthApiHost(), configuration);
        this.loginApiV2 = buildApi(LoginApiV2.class, configuration.getAuthApiHost(), configuration);
    }

    public TokenInfo getTokenInfo()
    {
        if (configuration.getLoginApiVersion() == LoginApiVersion.V1)
        {
            TokenInfoV1 tokenInfo = getTokenInfoV1(configuration);
            return new TokenInfo(tokenInfo.getAccessToken(), tokenInfo.getRefreshToken(), ApiClient.V1_API_URL, tokenInfo.getExpiresIn());
        }
        else
        {
            TokenInfoV2 tokenInfo = loginApiV2.getTokenInfo(new AuthDataV2(configuration.getUsername(), configuration.getPassword()));
            return new TokenInfo(tokenInfo.getAccessToken(), null, tokenInfo.getRestInstanceUrl(), tokenInfo.getExpiresIn());
        }
    }

    private TokenInfoV1 getTokenInfoV1(Configuration configuration)
    {
        if (StringUtils.isEmpty(configuration.getRefreshToken()))
        {
            return loginApiV1.getTokenInfo(new AuthDataV1(configuration.getUsername(), configuration.getPassword()));
        }
        else
        {
            return loginApiV1.getTokenInfo(new AuthWithRefreshTokenDataV1(configuration.getUsername(), configuration.getPassword(), "offline", configuration.getRefreshToken()));
        }
    }
}
