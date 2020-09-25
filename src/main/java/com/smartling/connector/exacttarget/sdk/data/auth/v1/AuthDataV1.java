package com.smartling.connector.exacttarget.sdk.data.auth.v1;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthDataV1
{
    private final String clientId;
    private final String clientSecret;
}
