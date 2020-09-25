package com.smartling.connector.exacttarget.sdk.data.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SimpleOperand implements LogicalOperand
{
    private final String property;
    private final String simpleOperator;
    private final String value;
}
