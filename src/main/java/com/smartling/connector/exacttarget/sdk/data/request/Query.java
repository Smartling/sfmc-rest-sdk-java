package com.smartling.connector.exacttarget.sdk.data.request;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Query
{
    @JsonUnwrapped
    private final LogicalOperand logicalOperand;
}
