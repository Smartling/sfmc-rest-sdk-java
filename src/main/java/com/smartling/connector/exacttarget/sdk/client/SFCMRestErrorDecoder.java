package com.smartling.connector.exacttarget.sdk.client;

import com.smartling.connector.exacttarget.sdk.rest.SFMCRestAuthenticationException;
import com.smartling.connector.exacttarget.sdk.rest.SFMCRestException;
import com.smartling.connector.exacttarget.sdk.rest.SFMCRestNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
public class SFCMRestErrorDecoder implements ErrorDecoder
{
    @Override
    public Exception decode(final String methodKey, final Response response)
    {
        String responseBody = bodyAsString(response);

        if (response.status() == 401)
        {
            String message = String.format("Authentication failed with HTTP %s: %s. Details: %s", response.status(), response.reason(), responseBody);
            return new SFMCRestAuthenticationException(message);
        }

        if (response.status() == 404)
        {
            String message = String.format("Asset not found HTTP %s: %s. Details: %s", response.status(), response.reason(), responseBody);
            return new SFMCRestNotFoundException(message);
        }

        String message = String.format("Exacttarget API responded with HTTP %s: %s. Details: %s", response.status(), response.reason(), responseBody);
        return new SFMCRestException(message);
    }

    private static String bodyAsString(final Response response)
    {
        if (response.body()!=null && response.body().length() > 0)
        {
            try (BufferedReader reader = new BufferedReader(response.body().asReader()))
            {
                return reader.lines().collect(Collectors.joining());
            }
            catch (IOException e)
            {
                log.warn("Failed to read response:", e);
                return null;
            }
        }
        else
        {
            return null;
        }
    }
}
