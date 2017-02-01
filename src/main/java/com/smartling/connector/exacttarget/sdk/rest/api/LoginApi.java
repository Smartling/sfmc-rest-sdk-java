package com.smartling.connector.exacttarget.sdk.rest.api;

import com.smartling.connector.exacttarget.sdk.data.AuthData;
import com.smartling.connector.exacttarget.sdk.data.AuthWithRefreshTokenData;
import com.smartling.connector.exacttarget.sdk.data.TokenInfo;
import feign.Headers;
import feign.RequestLine;

public interface LoginApi
{
    @RequestLine("POST /v1/requestToken")
    @Headers ("Content-Type: application/json")
    TokenInfo getTokenInfo(AuthData authData);

    @RequestLine("POST /v1/requestToken")
    @Headers ("Content-Type: application/json")
    TokenInfo getTokenInfo(AuthWithRefreshTokenData authData);
}
