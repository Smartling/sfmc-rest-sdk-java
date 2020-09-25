package com.smartling.connector.exacttarget.sdk.data.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Page
{
    private final Integer page;
    private final Integer pageSize;
}
