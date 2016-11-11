package com.smartling.connector.eloqua.sdk.data.request;

public class SimpleOperand implements LogicalOperand
{
    private final String property;
    private final String simpleOperator;
    private final String value;

    public SimpleOperand(final String property, final String simpleOperator, final String value)
    {
        this.property = property;
        this.simpleOperator = simpleOperator;
        this.value = value;
    }

    public String getProperty()
    {
        return property;
    }

    public String getSimpleOperator()
    {
        return simpleOperator;
    }

    public String getValue()
    {
        return value;
    }
}
