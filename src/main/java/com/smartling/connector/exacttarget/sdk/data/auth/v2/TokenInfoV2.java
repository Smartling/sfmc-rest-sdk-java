package com.smartling.connector.exacttarget.sdk.data.auth.v2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TokenInfoV2
{
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Long expiresIn;
    @JsonProperty("rest_instance_url")
    private String restInstanceUrl;
}
