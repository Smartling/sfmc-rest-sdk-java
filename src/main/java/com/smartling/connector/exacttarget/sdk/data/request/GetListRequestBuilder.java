package com.smartling.connector.exacttarget.sdk.data.request;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class GetListRequestBuilder
{
    private Page page;
    private List<Sort> sort = new ArrayList<>();
    private List<String> fields = new ArrayList<>();
    private LinkedList<LogicalOperand> operands = new LinkedList<>();

    private GetListRequestBuilder()
    {
    }

    public static GetListRequestBuilder builder()
    {
        return new GetListRequestBuilder();
    }

    public GetListRequestBuilder field(String field)
    {
        fields.add(field);
        return this;
    }

    public GetListRequestBuilder searchTerm(String searchTerm)
    {
        if (isNotEmpty(searchTerm))
        {
            operands.add(new SimpleOperand("name", "like", searchTerm));
        }

        return this;
    }

    public GetListRequestBuilder categoryId(String categoryId)
    {
        String id = isNotBlank(categoryId) ? categoryId : "0";
        operands.add(new SimpleOperand("category.id", "equals", id));

        return this;
    }

    public GetListRequestBuilder page(int page, int pageSize)
    {
        this.page = new Page(page, pageSize);

        return this;
    }

    public GetListRequestBuilder sort(String sortField, String sortDirection)
    {
        if (isNotEmpty(sortField) && isNotEmpty(sortDirection))
        {
            sort.add(new Sort(sortField, sortDirection));
        }

        return this;
    }

    public GetListRequest build()
    {
        return new GetListRequest(page, getQuery(), sort, fields);
    }

    private Query getQuery()
    {
        operands.addFirst(new SimpleIntOperand("assetType.id", "in", new int[] {207, 208, 209}));

        return new Query(getOperandFromList(operands));
    }

    private LogicalOperand getOperandFromList(List<LogicalOperand> operands)
    {
        if (operands.size() == 1)
        {
            return operands.get(0);
        }

        List<LogicalOperand> leftSublist = operands.subList(0, operands.size() / 2);
        List<LogicalOperand> rightSublist = operands.subList(operands.size() / 2, operands.size());

        return new ComplexOperand(getOperandFromList(leftSublist), "AND", getOperandFromList(rightSublist));
    }
}
