package com.smartling.connector.eloqua.sdk.data.request;

public class ComplexOperand implements LogicalOperand
{
    private final LogicalOperand rightOperand;
    private final String logicalOperator;
    private final LogicalOperand leftOperand;

    public ComplexOperand(final LogicalOperand rightOperand, final String logicalOperator, final LogicalOperand leftOperand)
    {
        this.rightOperand = rightOperand;
        this.logicalOperator = logicalOperator;
        this.leftOperand = leftOperand;
    }

    public LogicalOperand getRightOperand()
    {
        return rightOperand;
    }

    public String getLogicalOperator()
    {
        return logicalOperator;
    }

    public LogicalOperand getLeftOperand()
    {
        return leftOperand;
    }
}
