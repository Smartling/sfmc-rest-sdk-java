package com.smartling.connector.exacttarget.sdk.data;

public class Html
{
    private Object options;
    private String content;
    private Integer modelVersion;
    private String thumbnailHtml;
    private Template template;
    private Object slots;
    private Object data;

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

    public Template getTemplate()
    {
        return template;
    }

    public void setTemplate(final Template template)
    {
        this.template = template;
    }

    public Object getSlots()
    {
        return slots;
    }

    public void setSlots(final Object slots)
    {
        this.slots = slots;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }
}
