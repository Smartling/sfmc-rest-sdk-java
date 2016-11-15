package com.smartling.connector.exacttarget.sdk.data.request;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

public class GetListRequestBuilder
{
    public static GetListRequest build(int page, int pageSize, String searchTerm, String sortField, String sortDirection)
    {
        return new GetListRequest(new Page(page, pageSize), getQuery(searchTerm), getSort(sortField, sortDirection), "name");
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
        final SimpleOperand templateEmail = new SimpleOperand("contentType", "equals", "application/vnd.etmc.email.Message; kind=template");
        final SimpleOperand textEmail = new SimpleOperand("contentType", "equals", "application/vnd.etmc.email.Message; kind=textOnly");
        final SimpleOperand htmlPaste = new SimpleOperand("contentType", "equals", "application/vnd.etmc.email.Message; kind=paste");

        ComplexOperand textOrTemplate = new ComplexOperand(templateEmail, "OR", textEmail);
        ComplexOperand anyEmail = new ComplexOperand(textOrTemplate, "OR", htmlPaste);

        ComplexOperand toplvl = new ComplexOperand(anyEmail, "AND", new SimpleOperand("name", "contains", searchTerm));
        return new Query(toplvl);
    }
}
