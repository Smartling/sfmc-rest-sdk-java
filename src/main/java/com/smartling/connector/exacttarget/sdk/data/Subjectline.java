package com.smartling.connector.exacttarget.sdk.data;

public class Subjectline
{
    private String contentType;
    private Object options;
    private String content;
    private Object meta;
    private Integer modelVersion;

    public String getContentType()
    {
        return contentType;
    }

    public void setContentType(final String contentType)
    {
        this.contentType = contentType;
    }

    public Object getOptions()
    {
        return options;
    }

    public void setOptions(final Object options)
    {
        this.options = options;
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

    public Integer getModelVersion()
    {
        return modelVersion;
    }

    public void setModelVersion(final Integer modelVersion)
    {
        this.modelVersion = modelVersion;
    }
}
