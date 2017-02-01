package com.smartling.connector.exacttarget.sdk;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationTest
{
    private Configuration configuration;

    @Before
    public void setup()
    {
        configuration = new Configuration("username", "password", "refreshToken");
    }

    @Test(expected = NullPointerException.class)
    public void shouldValidateUsername() throws Exception
    {
        new Configuration(null, "password", null);
    }

    @Test(expected = NullPointerException.class)
    public void shouldValidatePassword() throws Exception
    {
        new Configuration("username", null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldValidateConnectionTimeout() throws Exception
    {
        configuration.setConnectTimeoutMillis(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldValidateReadTimeout() throws Exception
    {
        configuration.setReadTimeoutMillis(-1);
    }

    @Test
    public void testGetOptions() throws Exception
    {
        assertThat(configuration.getOptions().connectTimeoutMillis()).isEqualTo(configuration.getConnectTimeoutMillis());
        assertThat(configuration.getOptions().readTimeoutMillis()).isEqualTo(configuration.getReadTimeoutMillis());
    }
}