package com.smartling.connector.exacttarget.sdk.data.auth.v2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenInfoV2
{
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Long expiresIn;
    @JsonProperty("rest_instance_url")
    private String restInstanceUrl;

    public String getAccessToken()
    {
        return accessToken;
    }

    public void setAccessToken(String accessToken)
    {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn()
    {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn)
    {
        this.expiresIn = expiresIn;
    }

    public String getRestInstanceUrl()
    {
        return restInstanceUrl;
    }

    public void setRestInstanceUrl(String restInstanceUrl)
    {
        this.restInstanceUrl = restInstanceUrl;
    }
}
