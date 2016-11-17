package com.smartling.connector.exacttarget.sdk.data;

import com.smartling.connector.exacttarget.sdk.data.AssetType;

public class Template
{
    private AssetType assetType;
    private String name;
    private String content;
    private Object meta;
    private Object slots;

    public AssetType getAssetType()
    {
        return assetType;
    }

    public void setAssetType(final AssetType assetType)
    {
        this.assetType = assetType;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(final String content)
    {
        this.content = content;
    }

    public Object getMeta()
    {
        return meta;
    }

    public void setMeta(final Object meta)
    {
        this.meta = meta;
    }

    public Object getSlots()
    {
        return slots;
    }

    public void setSlots(final Object slots)
    {
        this.slots = slots;
    }
}
