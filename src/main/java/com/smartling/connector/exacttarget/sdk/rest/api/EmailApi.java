package com.smartling.connector.exacttarget.sdk.rest.api;

import com.smartling.connector.exacttarget.sdk.data.Elements;
import com.smartling.connector.exacttarget.sdk.data.Email;
import com.smartling.connector.exacttarget.sdk.data.Preview;
import com.smartling.connector.exacttarget.sdk.data.request.GetListRequest;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface EmailApi
{
    @RequestLine("POST /asset/v1/content/assets/query/")
    @Headers ("Content-Type: application/json") Elements<Email> listEmails(GetListRequest body);

    @RequestLine("GET /asset/v1/content/assets/{id}")
    Email getEmail(@Param("id") String id);

    @RequestLine("POST /guide/v1/emails/{id}/preview?kind=html")
    Preview getEmailPreview(@Param("id") String id);

    @RequestLine("POST /guide/v1/emails/{id}/dataExtension/{dataExtensionKey}/row/{rowId}/preview?kind=html")
    Preview getEmailPreview(@Param("id") String id, @Param("dataExtensionKey") String dataExtensionKey, @Param("rowId") String rowId);

    @RequestLine("POST /asset/v1/content/assets")
    @Headers ("Content-Type: application/json")
    Email createEmail(Email clonedEmail);

    @RequestLine("PUT /asset/v1/content/assets/{id}")
    @Headers ("Content-Type: application/json")
    Void updateEmail(@Param("id") String id, Email clonedEmail);

    @RequestLine("DELETE /asset/v1/content/assets/{id}")
    String deleteEmail(@Param("id") String id);
}
