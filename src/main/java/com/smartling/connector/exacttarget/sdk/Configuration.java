package com.smartling.connector.exacttarget.sdk;

import feign.Request;
import org.apache.commons.lang3.Validate;

public class Configuration
{
    private final String username;
    private final String password;

    private int connectTimeoutMillis = 10_000;
    private int readTimeoutMillis = 60_000;

    public Configuration(final String username, final String password)
    {
        this.username = Validate.notEmpty(username, "Username can not be empty");
        this.password = Validate.notEmpty(password, "Password can not be empty");
    }

    public Request.Options getOptions()
    {
        return new Request.Options(connectTimeoutMillis, readTimeoutMillis);
    }

    public int getConnectTimeoutMillis()
    {
        return connectTimeoutMillis;
    }

    public void setConnectTimeoutMillis(final int connectTimeoutMillis)
    {
        this.connectTimeoutMillis = validateNotNegative(connectTimeoutMillis);
    }

    public int getReadTimeoutMillis()
    {
        return readTimeoutMillis;
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

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
}