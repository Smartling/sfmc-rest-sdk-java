package com.smartling.connector.exacttarget.sdk.data.auth.v1;

import lombok.Data;

@Data
public class TokenInfoV1
{
    private String accessToken;
    private String refreshToken;
    private Long expiresIn;
}
