package com.smartling.connector.exacttarget.sdk.data.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Sort
{
    private final String property;
    private final String direction;
}
