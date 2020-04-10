package com.smartling.connector.exacttarget.sdk.data.auth.v2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthDataV2
{
    @JsonProperty("client_id")
    private final String clientId;
    @JsonProperty("client_secret")
    private final String clientSecret;
    @JsonProperty("grant_type")
    private final String grantType = "client_credentials";

    public AuthDataV2(final String clientId, final String clientSecret)
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

    public String getGrantType()
    {
        return grantType;
    }
}
