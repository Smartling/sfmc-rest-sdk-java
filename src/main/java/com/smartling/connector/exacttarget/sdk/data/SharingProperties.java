package com.smartling.connector.exacttarget.sdk.data;

import java.util.List;

public class SharingProperties
{
    private String sharingType;
    private List<Long> sharedWith;

    public String getSharingType()
    {
        return sharingType;
    }

    public void setSharingType(String sharingType)
    {
        this.sharingType = sharingType;
    }

    public List<Long> getSharedWith()
    {
        return sharedWith;
    }

    public void setSharedWith(List<Long> sharedWith)
    {
        this.sharedWith = sharedWith;
    }
}
