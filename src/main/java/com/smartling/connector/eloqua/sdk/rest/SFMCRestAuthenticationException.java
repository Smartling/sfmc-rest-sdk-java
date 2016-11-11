package com.smartling.connector.eloqua.sdk.rest;

import feign.FeignException;

public class SFMCRestAuthenticationException extends SFMCRestException
{
    public SFMCRestAuthenticationException(final String message)
    {
        super(message);
    }

    public SFMCRestAuthenticationException(final String message, final FeignException cause)
    {
        super(message, cause);
    }
}
