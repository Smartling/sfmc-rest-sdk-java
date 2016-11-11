package com.smartling.connector.eloqua.sdk.data.request;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Query
{
    @JsonUnwrapped
    private final LogicalOperand logicalOperand;

    public Query(final LogicalOperand logicalOperand)
    {
        this.logicalOperand = logicalOperand;
    }

    public LogicalOperand getLogicalOperand()
    {
        return logicalOperand;
    }
}
