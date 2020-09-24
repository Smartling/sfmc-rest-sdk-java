package com.smartling.connector.exacttarget.sdk.data;

import lombok.Data;

@Data
public class Views
{
    private Subjectline subjectline;
    private Object preheader;
    private Html html;
    private Text text;
    private Object viewAsAWebPage;
    private Object subscriptioncenter;
    private Object forwardHTML;
    private Object forwardText;
}
