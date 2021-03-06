package com.smartling.connector.exacttarget.sdk.data;

import lombok.Data;

import java.util.List;

@Data
public class SharingProperties
{
    private String sharingType;
    private List<Long> sharedWith;
}
