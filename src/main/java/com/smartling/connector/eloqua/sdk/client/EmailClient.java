package com.smartling.connector.eloqua.sdk.client;

import com.smartling.connector.eloqua.sdk.Configuration;
import com.smartling.connector.eloqua.sdk.data.Elements;
import com.smartling.connector.eloqua.sdk.data.Email;
import com.smartling.connector.eloqua.sdk.data.request.GetListRequestBuilder;
import com.smartling.connector.eloqua.sdk.rest.SFMCRestException;
import com.smartling.connector.eloqua.sdk.rest.api.EmailApi;

import java.util.UUID;

public class EmailClient extends ApiClient
{
    public static final int MAX_RETRY = 5;
    private EmailApi emailApi;

    public EmailClient(final Configuration configuration)
    {
        super(configuration);
        emailApi = buildApiWithOAuthAuthentication(EmailApi.class, BASE_API_URL);
    }

    public Elements<Email> getEmailsList(int page, int pageSize, String searchTerm, String sortField, String sortDirection)
    {
        return emailApi.listEmails(GetListRequestBuilder.build(page, pageSize, searchTerm, sortField, sortDirection));
    }

    public Email getEmail(String id)
    {
        return emailApi.getEmail(id);
    }

    public Email createEmail(Email translatedEmail)
    {
        for (int i=0; i< MAX_RETRY; i++)
        {
            translatedEmail.setCustomerKey(UUID.randomUUID().toString());
            try
            {
                return emailApi.createEmail(translatedEmail);
            }catch (SFMCRestException ex)
            {
                if (ex.getMessage().contains("Customer Key must be unique"))
                    continue;
                throw ex;
            }
        }
        throw new SFMCRestException("Can't pick unique CustomerKey");
    }

    public void updateEmail(String id, Email email)
    {
        emailApi.updateEmail(id, email);
    }

    public void deleteEmail(String id)
    {
        emailApi.deleteEmail(id);
    }
}
