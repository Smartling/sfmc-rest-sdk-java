package com.smartling.connector.eloqua.sdk.data;

public class TokenInfo
{
    private String accessToken;
    private Long expiresIn;
    public static final String TOKEN_TYPE = "Bearer";

    public String getAccessToken()
    {
        return accessToken;
    }

    public void setAccessToken(final String accessToken)
    {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn()
    {
        return expiresIn;
    }

    public void setExpiresIn(final Long expiresIn)
    {
        this.expiresIn = expiresIn;
    }

}
