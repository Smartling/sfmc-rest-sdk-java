package com.smartling.connector.exacttarget.sdk.data.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ComplexOperand implements LogicalOperand
{
    private final LogicalOperand rightOperand;
    private final String logicalOperator;
    private final LogicalOperand leftOperand;
}
