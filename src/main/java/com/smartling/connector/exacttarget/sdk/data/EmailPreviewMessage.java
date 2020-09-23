package com.smartling.connector.exacttarget.sdk.data;

import java.util.List;

public class EmailPreviewMessage
{
    private EmailPreviewLinks links;
    private List<EmailPreviewView> views;

    public EmailPreviewLinks getLinks()
    {
        return links;
    }

    public void setLinks(EmailPreviewLinks links)
    {
        this.links = links;
    }

    public List<EmailPreviewView> getViews()
    {
        return views;
    }

    public void setViews(List<EmailPreviewView> views)
    {
        this.views = views;
    }
}
