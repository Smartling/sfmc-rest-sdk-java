package com.smartling.connector.exacttarget.sdk.data;

import java.util.List;

public class Elements<T>
{
    private Integer count;
    private Integer page;
    private Integer pageSize;
    private Object links;
    private List<T> items;

    public Integer getCount()
    {
        return count;
    }

    public void setCount(final Integer count)
    {
        this.count = count;
    }

    public Integer getPage()
    {
        return page;
    }

    public void setPage(final Integer page)
    {
        this.page = page;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(final Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public Object getLinks()
    {
        return links;
    }

    public void setLinks(final Object links)
    {
        this.links = links;
    }

    public List<T> getItems()
    {
        return items;
    }

    public void setItems(final List<T> items)
    {
        this.items = items;
    }
}
