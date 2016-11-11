package com.smartling.connector.eloqua.sdk;

import com.smartling.connector.eloqua.sdk.client.EmailClient;
import com.smartling.connector.eloqua.sdk.data.Elements;
import com.smartling.connector.eloqua.sdk.data.Email;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailIntegrationTest extends BaseIntegrationTest
{
    @Test
    public void testGetClientList()
    {
        EmailClient emailClient = new EmailClient(configuration);
        final Elements<Email> emails = emailClient.getEmailsList(1, 10, "", "modifiedDate", "DESC");

        assertThat(emails).isNotNull();
        assertThat(emails.getPage()).isEqualTo(1);
        assertThat(emails.getPageSize()).isEqualTo(10);
        assertThat(emails.getCount()).isGreaterThan(0);
        assertThat(emails.getItems()).isNotEmpty();
        assertThat(emails.getItems().get(0)).isNotNull();

        if(emails.getCount() > 1)
        {
            assertThat(emails.getItems().get(0).getModifiedDate().after(emails.getItems().get(1).getModifiedDate()));
        }

        final Email emailToClone = emailClient.getEmail(emails.getItems().get(0).getId());
        emailToClone.setName(emailToClone.getName()+"(1)");
        final Email clonedEmail = emailClient.createEmail(emailToClone);
        assertThat(emailClient.getEmailsList(1, 10, clonedEmail.getName(), "modifiedDate", "DESC").getCount()).isGreaterThan(1);
        clonedEmail.setName("UnIqUe_Name");
        emailClient.updateEmail(clonedEmail.getId(), clonedEmail);
        assertThat(emailClient.getEmailsList(1, 10, "UnIqUe_Name", "modifiedDate", "DESC").getItems().get(0).getId()).isEqualTo(clonedEmail.getId());
        emailClient.deleteEmail(clonedEmail.getId());
    }
}
