package com.smartling.connector.eloqua.sdk.client;

import com.smartling.connector.eloqua.sdk.rest.SFMCRestAuthenticationException;
import feign.Response;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class SFCMRestErrorDecoderTest
{
    private final SFCMRestErrorDecoder testedInstance = new SFCMRestErrorDecoder();

    @Test
    public void shouldReturnAuthenticationExceptionFor401() throws Exception
    {
        Response response = Response.create(401, "Unauthorized", Collections.emptyMap(), new byte[0]);

        Exception exception = testedInstance.decode("", response);

        assertThat(exception)
                .isExactlyInstanceOf(SFMCRestAuthenticationException.class)
                .hasMessage("Authentication failed with HTTP 401: Unauthorized. Details: null");
    }

}