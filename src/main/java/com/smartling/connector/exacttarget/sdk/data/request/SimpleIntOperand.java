package com.smartling.connector.exacttarget.sdk.data.request;

import lombok.Getter;

@Getter
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
}
