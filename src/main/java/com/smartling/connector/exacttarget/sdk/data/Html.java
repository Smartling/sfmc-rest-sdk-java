package com.smartling.connector.exacttarget.sdk.data;

import lombok.Data;

@Data
public class Html
{
    private Object options;
    private String content;
    private Integer modelVersion;
    private String thumbnailHtml;
    private Template template;
    private Object slots;
    private Object data;
}
