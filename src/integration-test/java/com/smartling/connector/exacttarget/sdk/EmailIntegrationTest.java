package com.smartling.connector.exacttarget.sdk;

import com.smartling.connector.exacttarget.sdk.client.EmailClient;
import com.smartling.connector.exacttarget.sdk.client.LoginClient;
import com.smartling.connector.exacttarget.sdk.data.Elements;
import com.smartling.connector.exacttarget.sdk.data.Email;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailIntegrationTest extends BaseIntegrationTest
{
    @Test
    public void testGetClientList()
    {
        LoginClient loginClient = new LoginClient(configuration);
        EmailClient emailClient = new EmailClient(configuration, loginClient.getTokenInfo());
        Elements<Email> emails = emailClient.getEmailsList(1, 10, "10th", "modifiedDate", "DESC");

        assertThat(emails).isNotNull();
        assertThat(emails.getPage()).isEqualTo(1);
        assertThat(emails.getPageSize()).isLessThanOrEqualTo(10);
        assertThat(emails.getCount()).isGreaterThan(0);
        assertThat(emails.getItems()).isNotEmpty();
        assertThat(emails.getItems().get(0)).isNotNull();

        if(emails.getCount() > 1)
        {
            assertThat(emails.getItems().get(0).getModifiedDate().after(emails.getItems().get(1).getModifiedDate()));
        }

        final Email emailToClone = emailClient.getEmail(emails.getItems().get(0).getId());
        emailToClone.setName(emailToClone.getName()+"(aw)");
    //    emailToClone.setThumbnailHtml(emailToClone.getThumbnailHtml().replaceAll("Update Profile", "X_0_o_X"));
        emailToClone.getViews().getHtml().setContent(emailToClone.getViews().getHtml().getContent().replaceAll("Update Profile", "X_0_o_X"));

        final Email clonedEmail = emailClient.createEmail(emailToClone);
//        assertThat(emailClient.getEmailsList(1, 10, clonedEmail.getName(), "modifiedDate", "DESC").getCount()).isGreaterThan(1);
        clonedEmail.setThumbnailHtml(clonedEmail.getThumbnailHtml().replaceAll("Update Profile", "X_0_o_X"));
        emailClient.updateEmail(clonedEmail.getId(), clonedEmail);
        assertThat(emailClient.getEmailsList(1, 10, "UnIqUe_Name", "modifiedDate", "DESC").getItems().get(0).getId()).isEqualTo(clonedEmail.getId());
        emailClient.deleteEmail(clonedEmail.getId());
    }

    @Test
    public void testGettingFieldWithEmptySorting()
    {
        LoginClient loginClient = new LoginClient(configuration);
        EmailClient emailClient = new EmailClient(configuration, loginClient.getTokenInfo());

        final Elements<Email> emails = emailClient.getEmailsList(1, 10, "", "", "");
        assertThat(emails).isNotNull();
    }
}
