package com.smartling.connector.exacttarget.sdk.data;

public class Html
{
    private Object options;
    private String content;
    private Integer modelVersion;
    private String thumbnailHtml;

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

    public String getThumbnailHtml()
    {
        return thumbnailHtml;
    }

    public void setThumbnailHtml(final String thumbnailHtml)
    {
        this.thumbnailHtml = thumbnailHtml;
    }
}
