package com.smartling.connector.exacttarget.sdk.data;

import lombok.Data;

import java.util.List;

@Data
public class Elements<T>
{
    private Integer count;
    private Integer page;
    private Integer pageSize;
    private Object links;
    private List<T> items;
}
