package com.smartling.connector.exacttarget.sdk.data;

public class Text
{
    private Object options;
    private String content;
    private Integer modelVersion;

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

    public Integer getModelVersion()
    {
        return modelVersion;
    }

    public void setModelVersion(final Integer modelVersion)
    {
        this.modelVersion = modelVersion;
    }
}
