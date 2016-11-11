package com.smartling.connector.eloqua.sdk.data.request;

import java.util.Collections;

public class GetListRequestBuilder
{
    public static GetListRequest build(int page, int pageSize, String searchTerm, String sortField, String sortDirection)
    {
        return new GetListRequest(new Page(page, pageSize), getQuery(searchTerm), Collections.singletonList(new Sort(sortField, sortDirection)), "name");
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
