package com.smartling.connector.exacttarget.sdk.rest.api;

import com.smartling.connector.exacttarget.sdk.data.auth.v1.AuthDataV1;
import com.smartling.connector.exacttarget.sdk.data.auth.v1.AuthWithRefreshTokenDataV1;
import com.smartling.connector.exacttarget.sdk.data.auth.v1.TokenInfoV1;
import feign.Headers;
import feign.RequestLine;

public interface LoginApiV1
{
    @RequestLine("POST /v1/requestToken")
    @Headers ("Content-Type: application/json")
    TokenInfoV1 getTokenInfo(AuthDataV1 authData);

    @RequestLine("POST /v1/requestToken")
    @Headers ("Content-Type: application/json")
    TokenInfoV1 getTokenInfo(AuthWithRefreshTokenDataV1 authData);
}
