package com.smartling.connector.exacttarget.sdk.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Email
{
    private String id;
    private String customerKey;
    private String objectID;
    private String contentType;
    private AssetType assetType;
    private String name;
    private String description;
    private Object owner;
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private Date createdDate;
    private Object createdBy;
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private Date modifiedDate;
    private Object modifiedBy;
    private Long enterpriseId;
    private Long memberId;
    private Status status;
    private String thumbnailHtml;
    private String thumbnailImage;
    private String thumbnailUrl;
    private Category category;
    private Options options;
    private LegacyData legacyData;
    private Views views;
    private Object meta;
    private Long modelVersion;
    private SharingProperties sharingProperties;
    private AssetData data;
}
