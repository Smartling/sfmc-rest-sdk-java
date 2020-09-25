package com.smartling.connector.exacttarget.sdk;

import com.smartling.connector.exacttarget.sdk.client.ApiClient;
import com.smartling.connector.exacttarget.sdk.client.LoginApiVersion;
import feign.Request;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

@Getter
public class Configuration
{
    private final String username;
    private final String password;
    private final String refreshToken;
    private final String authApiHost;
    private final LoginApiVersion loginApiVersion;

    private int connectTimeoutMillis = 10_000;
    private int readTimeoutMillis = 60_000;

    public Configuration(final String username,
                         final String password,
                         final String refreshToken,
                         final String authApiHost,
                         final LoginApiVersion loginApiVersion)
    {
        this.refreshToken = refreshToken;
        this.username = Validate.notEmpty(username, "Username can not be empty");
        this.password = Validate.notEmpty(password, "Password can not be empty");
        this.authApiHost = StringUtils.isEmpty(authApiHost) ? ApiClient.V1_AUTH_API_URL: authApiHost;
        this.loginApiVersion = Validate.notNull(loginApiVersion, "LoginApiVersion can not be null");
    }

    public Request.Options getOptions()
    {
        return new Request.Options(connectTimeoutMillis, readTimeoutMillis);
    }

    public void setConnectTimeoutMillis(final int connectTimeoutMillis)
    {
        this.connectTimeoutMillis = validateNotNegative(connectTimeoutMillis);
    }

    public void setReadTimeoutMillis(final int readTimeoutMillis)
    {
        this.readTimeoutMillis = validateNotNegative(readTimeoutMillis);
    }

    private static int validateNotNegative(int value)
    {
        Validate.inclusiveBetween(0, Integer.MAX_VALUE, value);
        return value;
    }
}
