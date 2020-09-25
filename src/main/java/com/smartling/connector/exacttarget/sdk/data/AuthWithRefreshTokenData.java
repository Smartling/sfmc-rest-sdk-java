package com.smartling.connector.exacttarget.sdk.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AuthWithRefreshTokenData
{
    private final String clientId;
    private final String clientSecret;
    private final String accessType;
    private final String refreshToken;
}
