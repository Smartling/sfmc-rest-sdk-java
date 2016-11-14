package com.smartling.connector.exacttarget.sdk.data.request;

import java.util.List;

public class GetListRequest
{
    private final Page page;
    private final Query query;
    private final List<Sort> sort;
    private final String[] fields;

    public GetListRequest(final Page page, final Query query, final List<Sort> sort, final String... fields)
    {
        this.page = page;
        this.query = query;
        this.sort = sort;
        this.fields = fields;
    }

    public Page getPage()
    {
        return page;
    }

    public Query getQuery()
    {
        return query;
    }

    public List<Sort> getSort()
    {
        return sort;
    }

    public String[] getFields()
    {
        return fields;
    }
}
