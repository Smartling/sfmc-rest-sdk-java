package com.smartling.connector.eloqua.sdk.rest;

import feign.FeignException;

public class SFMCRestException extends RuntimeException
{
    public SFMCRestException(final String message)
    {
        super(message);
    }

    public SFMCRestException(final String message, final FeignException cause)
    {
        super(message, cause);
    }

}
