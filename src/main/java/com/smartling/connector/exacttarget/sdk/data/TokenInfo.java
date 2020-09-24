package com.smartling.connector.exacttarget.sdk.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenInfo
{
    private String accessToken;
    private String refreshToken;
    private String restApiHost;
    private Long expiresIn;
    public static final String TOKEN_TYPE = "Bearer";
}
