package com.smartling.connector.exacttarget.sdk.data.request;

public class SimpleIntOperand implements LogicalOperand
{
    private final String property;
    private final String simpleOperator;
    private final String valueType;
    private final int[] value;

    public SimpleIntOperand(final String property, final String simpleOperator, final int[] value)
    {
        this.property = property;
        this.simpleOperator = simpleOperator;
        this.value = value;
        this.valueType = "int";
    }

    public String getProperty()
    {
        return property;
    }

    public String getSimpleOperator()
    {
        return simpleOperator;
    }

    public String getValueType()
    {
        return valueType;
    }

    public int[] getValue()
    {
        return value;
    }
}
