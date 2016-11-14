package com.smartling.connector.exacttarget.sdk;

import org.junit.Before;

import static org.junit.Assume.assumeNotNull;

public class BaseIntegrationTest
{
    protected Configuration configuration;

    protected String password;
    protected String username;

    @Before
    public void setUp() throws Exception
    {
        username = System.getProperty("sfmc.username");
        password = System.getProperty("sfmc.password");

        assumeNotNull("Username is not specified", username);
        assumeNotNull("Password is not specified", password);

        this.configuration = new Configuration(username, password);
    }

}
