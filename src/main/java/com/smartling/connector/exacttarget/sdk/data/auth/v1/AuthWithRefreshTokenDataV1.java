package com.smartling.connector.exacttarget.sdk.data.auth.v1;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthWithRefreshTokenDataV1
{
    private final String clientId;
    private final String clientSecret;
    private final String accessType;
    private final String refreshToken;
}
