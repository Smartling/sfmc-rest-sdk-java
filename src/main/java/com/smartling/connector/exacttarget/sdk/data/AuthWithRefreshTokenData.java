package com.smartling.connector.exacttarget.sdk.data;

public class AuthWithRefreshTokenData
{
    private final String clientId;
    private final String clientSecret;
    private final String accessType = "online";
    private final String refresfToken;

    public AuthWithRefreshTokenData(final String clientId, final String clientSecret, final String refresfToken)
    {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
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
