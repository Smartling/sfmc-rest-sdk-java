package com.smartling.connector.exacttarget.sdk.rest;

import feign.FeignException;

public class SFMCRestNotFoundException extends SFMCRestException
{

    public SFMCRestNotFoundException(final String message)
    {
        super(message);
    }

    public SFMCRestNotFoundException(final String message, final FeignException cause)
    {
        super(message, cause);
    }
}
