package com.smartling.connector.exacttarget.sdk.data;

public class TokenInfo
{
    private String accessToken;
    private String refreshToken;
    private String restApiHost;
    private Long expiresIn;
    public static final String TOKEN_TYPE = "Bearer";

    public TokenInfo()
    {

    }

    public TokenInfo(String accessToken, String refreshToken, String restApiHost, Long expiresIn)
    {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.restApiHost = restApiHost;
        this.expiresIn = expiresIn;
    }

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

    public String getRefreshToken()
    {
        return refreshToken;
    }

    public void setRefreshToken(final String refreshToken)
    {
        this.refreshToken = refreshToken;
    }

    public String getRestApiHost()
    {
        return restApiHost;
    }

    public void setRestApiHost(String restApiHost)
    {
        this.restApiHost = restApiHost;
    }
}
