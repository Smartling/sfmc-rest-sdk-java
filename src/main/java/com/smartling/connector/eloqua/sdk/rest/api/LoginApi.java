package com.smartling.connector.eloqua.sdk.rest.api;

import com.smartling.connector.eloqua.sdk.data.AuthData;
import com.smartling.connector.eloqua.sdk.data.TokenInfo;
import feign.Headers;
import feign.RequestLine;

public interface LoginApi
{
    @RequestLine("POST /v1/requestToken")
    @Headers ("Content-Type: application/json")
    TokenInfo getTokenInfo(AuthData authData);
}
