package com.smartling.connector.eloqua.sdk.data.request;

public class Sort
{
    private final String property;
    private final String direction;

    public Sort(final String property, final String direction)
    {
        this.property = property;
        this.direction = direction;
    }

    public String getProperty()
    {
        return property;
    }

    public String getDirection()
    {
        return direction;
    }
}
