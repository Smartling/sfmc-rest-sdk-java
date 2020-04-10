package com.smartling.connector.exacttarget.sdk.data.auth.v1;

public class AuthDataV1
{
    private final String clientId;
    private final String clientSecret;

    public AuthDataV1(String clientId, String clientSecret)
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
