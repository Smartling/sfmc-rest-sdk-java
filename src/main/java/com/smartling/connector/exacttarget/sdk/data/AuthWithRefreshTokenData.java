package com.smartling.connector.exacttarget.sdk.data;

public class AuthWithRefreshTokenData
{
    private final String clientId;
    private final String clientSecret;
    private final String accessType;
    private final String refreshToken;

    public AuthWithRefreshTokenData(final String clientId, final String clientSecret, final String accessType, final String refreshToken)
    {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.accessType = accessType;
        this.refreshToken = refreshToken;
    }

    public String getClientId()
    {
        return clientId;
    }

    public String getClientSecret()
    {
        return clientSecret;
    }

    public String getAccessType()
    {
        return accessType;
    }

    public String getRefreshToken()
    {
        return refreshToken;
    }
}
