package com.smartling.connector.exacttarget.sdk.data;

import lombok.Data;

@Data
public class Template
{
    private Long id;
    private AssetType assetType;
    private String name;
    private String content;
    private Object meta;
    private Object slots;
    private Object options;
    private String customerKey;
    private String objectID;
    private Object owner;
    private String enterpriseId;
    private String memberId;
    private Object status;
    private String thumbnailUrl;
    private Object category;
}
