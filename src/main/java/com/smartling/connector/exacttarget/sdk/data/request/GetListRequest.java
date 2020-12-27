package com.smartling.connector.exacttarget.sdk.data.request;

import lombok.Getter;

import java.util.List;

@Getter
public class GetListRequest
{
    private final Page page;
    private final Query query;
    private final List<Sort> sort;
    private final List<String> fields;

    public GetListRequest(Page page, Query query, List<Sort> sort, List<String> fields)
    {
        this.page = page;
        this.query = query;
        this.sort = sort;
        this.fields = fields;
    }
}
