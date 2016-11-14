package com.smartling.connector.exacttarget.sdk.data.request;

public class Page
{
    private final Integer page;
    private final Integer pageSize;

    public Page(final Integer page, final Integer pageSize)
    {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Integer getPage()
    {
        return page;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }
}
