package com.smartling.connector.exacttarget.sdk.data;

public class AuthData
{
    private String clientId;
    private String clientSecret;

    public AuthData(final String clientId, final String clientSecret)
    {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getClientId()
    {
        return clientId;
    }

    public String getClientSecret()
    {
        return clientSecret;
    }
}
