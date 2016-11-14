package com.smartling.connector.exacttarget.sdk;

import com.smartling.connector.exacttarget.sdk.data.TokenInfo;
import feign.RequestInterceptor;
import feign.RequestTemplate;

import static com.smartling.connector.exacttarget.sdk.data.TokenInfo.TOKEN_TYPE;

public class OAuthRequestInterceptor implements RequestInterceptor
{
    private final String headerValue;

    public OAuthRequestInterceptor (TokenInfo tokenInfo)
    {
        headerValue = TOKEN_TYPE + ' ' + tokenInfo.getAccessToken();
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", headerValue);
    }
}
