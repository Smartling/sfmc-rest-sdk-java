package com.smartling.connector.exacttarget.sdk.data.auth.v1;

public class AuthWithRefreshTokenDataV1
{
    private final String clientId;
    private final String clientSecret;
    private final String accessType;
    private final String refreshToken;

    public AuthWithRefreshTokenDataV1(final String clientId, final String clientSecret, final String accessType, final String refreshToken)
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
