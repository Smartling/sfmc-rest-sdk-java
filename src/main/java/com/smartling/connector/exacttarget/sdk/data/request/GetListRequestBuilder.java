package com.smartling.connector.exacttarget.sdk.data.request;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

public class GetListRequestBuilder
{
    public static GetListRequest build(int page, int pageSize, String searchTerm, String sortField, String sortDirection)
    {
        return new GetListRequest(new Page(page, pageSize), getQuery(searchTerm), getSort(sortField, sortDirection), "name", "category", "status", "modifiedDate");
    }

    private static List<Sort> getSort(final String sortField, final String sortDirection)
    {
        if (!StringUtils.isEmpty(sortField) && !StringUtils.isEmpty(sortDirection))
        {
            return Collections.singletonList(new Sort(sortField, sortDirection));
        }else
        {
            return null;
        }
    }

    private static Query getQuery(final String searchTerm)
    {
        final SimpleIntOperand anyEmail = new SimpleIntOperand("assetType.id", "in", new int[]{207, 208, 209});

        ComplexOperand toplvl = new ComplexOperand(anyEmail, "AND", new SimpleOperand("name", "like", searchTerm));
        return new Query(toplvl);
    }
}
