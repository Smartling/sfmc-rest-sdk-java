package com.smartling.connector.exacttarget.sdk.data;

public class Text
{
    private Object options;
    private String content;
    private Integer modelVersion;
    private Object data;
    private Object generateFrom;

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

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public Object getGenerateFrom()
    {
        return generateFrom;
    }

    public void setGenerateFrom(Object generateFrom)
    {
        this.generateFrom = generateFrom;
    }
}
