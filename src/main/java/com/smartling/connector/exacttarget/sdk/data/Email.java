package com.smartling.connector.exacttarget.sdk.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Email
{
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private String id;
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private String customerKey;
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
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
    private Legacy legacy;
    private Views views;
    private Long modelVersion;

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public String getCustomerKey()
    {
        return customerKey;
    }

    public void setCustomerKey(final String customerKey)
    {
        this.customerKey = customerKey;
    }

    public String getObjectID()
    {
        return objectID;
    }

    public void setObjectID(final String objectID)
    {
        this.objectID = objectID;
    }

    public String getContentType()
    {
        return contentType;
    }

    public void setContentType(final String contentType)
    {
        this.contentType = contentType;
    }

    public AssetType getAssetType()
    {
        return assetType;
    }

    public void setAssetType(final AssetType assetType)
    {
        this.assetType = assetType;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public Object getOwner()
    {
        return owner;
    }

    public void setOwner(final Object owner)
    {
        this.owner = owner;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(final Date createdDate)
    {
        this.createdDate = createdDate;
    }

    public Object getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(final Object createdBy)
    {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate()
    {
        return modifiedDate;
    }

    public void setModifiedDate(final Date modifiedDate)
    {
        this.modifiedDate = modifiedDate;
    }

    public Object getModifiedBy()
    {
        return modifiedBy;
    }

    public void setModifiedBy(final Object modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }

    public Long getEnterpriseId()
    {
        return enterpriseId;
    }

    public void setEnterpriseId(final Long enterpriseId)
    {
        this.enterpriseId = enterpriseId;
    }

    public Long getMemberId()
    {
        return memberId;
    }

    public void setMemberId(final Long memberId)
    {
        this.memberId = memberId;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(final Status status)
    {
        this.status = status;
    }

    public String getThumbnailUrl()
    {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(final String thumbnailUrl)
    {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(final Category category)
    {
        this.category = category;
    }

    public Options getOptions()
    {
        return options;
    }

    public void setOptions(final Options options)
    {
        this.options = options;
    }

    public Legacy getLegacy()
    {
        return legacy;
    }

    public void setLegacy(final Legacy legacy)
    {
        this.legacy = legacy;
    }

    public Views getViews()
    {
        return views;
    }

    public void setViews(final Views views)
    {
        this.views = views;
    }

    public Long getModelVersion()
    {
        return modelVersion;
    }

    public void setModelVersion(final Long modelVersion)
    {
        this.modelVersion = modelVersion;
    }

    public String getThumbnailHtml()
    {
        return thumbnailHtml;
    }

    public void setThumbnailHtml(final String thumbnailHtml)
    {
        this.thumbnailHtml = thumbnailHtml;
    }

    public String getThumbnailImage()
    {
        return thumbnailImage;
    }

    public void setThumbnailImage(final String thumbnailImage)
    {
        this.thumbnailImage = thumbnailImage;
    }
}
