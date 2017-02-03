package com.smartling.connector.exacttarget.sdk.data;

public class AuthWithRefreshTokenData
{
    private final String clientId;
    private final String clientSecret;
    private final String accessType;
    private final String refresfToken;

    public AuthWithRefreshTokenData(final String clientId, final String clientSecret, final String accessType, final String refresfToken)
    {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.accessType = accessType;
        this.refresfToken = refresfToken;
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

    public String getRefresfToken()
    {
        return refresfToken;
    }
}
