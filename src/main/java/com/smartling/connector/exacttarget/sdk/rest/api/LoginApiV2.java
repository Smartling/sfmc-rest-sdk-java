package com.smartling.connector.exacttarget.sdk.rest.api;

import com.smartling.connector.exacttarget.sdk.data.auth.v2.AuthDataV2;
import com.smartling.connector.exacttarget.sdk.data.auth.v2.TokenInfoV2;
import feign.Headers;
import feign.RequestLine;

public interface LoginApiV2
{
    @RequestLine("POST /v2/token")
    @Headers("Content-Type: application/json")
    TokenInfoV2 getTokenInfo(AuthDataV2 authData);
}
