package com.smartling.connector.exacttarget.sdk.client;

import com.smartling.connector.exacttarget.sdk.Configuration;
import com.smartling.connector.exacttarget.sdk.data.DefaultPreview;
import com.smartling.connector.exacttarget.sdk.data.Elements;
import com.smartling.connector.exacttarget.sdk.data.Email;
import com.smartling.connector.exacttarget.sdk.data.Preview;
import com.smartling.connector.exacttarget.sdk.data.TokenInfo;
import com.smartling.connector.exacttarget.sdk.data.request.GetListRequestBuilder;
import com.smartling.connector.exacttarget.sdk.rest.SFMCRestException;
import com.smartling.connector.exacttarget.sdk.rest.api.EmailApi;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Slf4j
public class EmailClient extends ApiClient
{
    public static final int MAX_RETRY = 5;
    private EmailApi emailApi;

    public EmailClient(final Configuration configuration, TokenInfo tokenInfo)
    {
        super(configuration, tokenInfo);
        emailApi = buildApiWithOAuthAuthentication(EmailApi.class, tokenInfo.getRestApiHost());
    }

    public Elements<Email> getEmailsList(int page, int pageSize, String searchTerm, String categoryId, String sortField, String sortDirection)
    {
        GetListRequestBuilder getListRequestBuilder = GetListRequestBuilder.builder()
                .page(page, pageSize)
                .searchTerm(searchTerm)
                .sort(sortField, sortDirection)
                .field("name")
                .field("category")
                .field("status")
                .field("modifiedDate");

        if (isBlank(searchTerm))
        {
            getListRequestBuilder.categoryId(categoryId);
        }

        return emailApi.listEmails(getListRequestBuilder.build());
    }

    public Email getEmail(String id)
    {
        return emailApi.getEmail(id);
    }

    public Preview getEmailPreview(String id)
    {
        return emailApi.getEmailPreview(id);
    }

    public Preview getEmailPreview(String id, String dataExtensionKey, String rowId)
    {
        return emailApi.getEmailPreview(id, dataExtensionKey, rowId);
    }

    public DefaultPreview getDefaultEmailPreview(String id)
    {
        return emailApi.getDefaultEmailPreview(id);
    }

    public Email createEmail(Email translatedEmail)
    {
        translatedEmail.setId(null);
        translatedEmail.setObjectID(null);
        for (int i=0; i< MAX_RETRY; i++)
        {
            translatedEmail.setCustomerKey(UUID.randomUUID().toString());
            try
            {
                return emailApi.createEmail(translatedEmail);
            }
            catch (SFMCRestException ex)
            {
                if (ex.getMessage().contains("Customer Key must be unique"))
                {
                    log.info("Customer Key is not unique {}", translatedEmail.getCustomerKey());
                    continue;
                }
                log.info("Failed to create email", ex);
                throw ex;
            }
        }
        throw new SFMCRestException("Can't pick unique CustomerKey");
    }

    public void updateEmail(String id, Email email)
    {
        emailApi.updateEmail(id, email);
    }

    public String deleteEmail(String id)
    {
        return emailApi.deleteEmail(id);
    }
}
