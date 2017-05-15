package com.hanv.ads.service.dto;


import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Post entity.
 */
public class PostDTO implements Serializable {

    private String id;

    private String message;

    @Size(max = 45)
    private String pageId;

    @Size(max = 45)
    private String pageName;

    @Size(max = 250)
    private String category;

    @Size(max = 250)
    private String categories;

    @Size(max = 250)
    private String postLink;

    @Size(max = 500)
    private String picture;

    @Size(max = 500)
    private String fullPicture;

    @Max(value = 20)
    private Long shareCount;

    @Max(value = 20)
    private Long reactionsCount;

    @Max(value = 20)
    private Long commentCount;

    @Max(value = 20)
    private Long likeCount;

    @Max(value = 20)
    private Long loveCount;

    @Max(value = 20)
    private Long wowCount;

    @Max(value = 20)
    private Long hahaCount;

    @Max(value = 20)
    private Long sadCount;

    @Max(value = 20)
    private Long angryCount;

    @Max(value = 20)
    private Long thankfulCount;

    private ZonedDateTime createdTime;

    private ZonedDateTime createdDateRecord;

    private String createdByRecord;

    private ZonedDateTime modifiedDateRecord;

    private String modifiedByRecord;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getPostLink() {
        return postLink;
    }

    public void setPostLink(String postLink) {
        this.postLink = postLink;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFullPicture() {
        return fullPicture;
    }

    public void setFullPicture(String fullPicture) {
        this.fullPicture = fullPicture;
    }

    public Long getShareCount() {
        return shareCount;
    }

    public void setShareCount(Long shareCount) {
        this.shareCount = shareCount;
    }

    public Long getReactionsCount() {
        return reactionsCount;
    }

    public void setReactionsCount(Long reactionsCount) {
        this.reactionsCount = reactionsCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getLoveCount() {
        return loveCount;
    }

    public void setLoveCount(Long loveCount) {
        this.loveCount = loveCount;
    }

    public Long getWowCount() {
        return wowCount;
    }

    public void setWowCount(Long wowCount) {
        this.wowCount = wowCount;
    }

    public Long getHahaCount() {
        return hahaCount;
    }

    public void setHahaCount(Long hahaCount) {
        this.hahaCount = hahaCount;
    }

    public Long getSadCount() {
        return sadCount;
    }

    public void setSadCount(Long sadCount) {
        this.sadCount = sadCount;
    }

    public Long getAngryCount() {
        return angryCount;
    }

    public void setAngryCount(Long angryCount) {
        this.angryCount = angryCount;
    }

    public Long getThankfulCount() {
        return thankfulCount;
    }

    public void setThankfulCount(Long thankfulCount) {
        this.thankfulCount = thankfulCount;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public ZonedDateTime getCreatedDateRecord() {
        return createdDateRecord;
    }

    public void setCreatedDateRecord(ZonedDateTime createdDateRecord) {
        this.createdDateRecord = createdDateRecord;
    }

    public String getCreatedByRecord() {
        return createdByRecord;
    }

    public void setCreatedByRecord(String createdByRecord) {
        this.createdByRecord = createdByRecord;
    }

    public ZonedDateTime getModifiedDateRecord() {
        return modifiedDateRecord;
    }

    public void setModifiedDateRecord(ZonedDateTime modifiedDateRecord) {
        this.modifiedDateRecord = modifiedDateRecord;
    }

    public String getModifiedByRecord() {
        return modifiedByRecord;
    }

    public void setModifiedByRecord(String modifiedByRecord) {
        this.modifiedByRecord = modifiedByRecord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PostDTO postDTO = (PostDTO) o;
        if(postDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), postDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PostDTO{" +
            "id=" + getId() +
            ", message='" + getMessage() + "'" +
            ", pageId='" + getPageId() + "'" +
            ", pageName='" + getPageName() + "'" +
            ", category='" + getCategory() + "'" +
            ", categories='" + getCategories() + "'" +
            ", postLink='" + getPostLink() + "'" +
            ", picture='" + getPicture() + "'" +
            ", fullPicture='" + getFullPicture() + "'" +
            ", shareCount='" + getShareCount() + "'" +
            ", reactionsCount='" + getReactionsCount() + "'" +
            ", commentCount='" + getCommentCount() + "'" +
            ", likeCount='" + getLikeCount() + "'" +
            ", loveCount='" + getLoveCount() + "'" +
            ", wowCount='" + getWowCount() + "'" +
            ", hahaCount='" + getHahaCount() + "'" +
            ", sadCount='" + getSadCount() + "'" +
            ", angryCount='" + getAngryCount() + "'" +
            ", thankfulCount='" + getThankfulCount() + "'" +
            ", createdTime='" + getCreatedTime() + "'" +
            ", createdDateRecord='" + getCreatedDateRecord() + "'" +
            ", createdByRecord='" + getCreatedByRecord() + "'" +
            ", modifiedDateRecord='" + getModifiedDateRecord() + "'" +
            ", modifiedByRecord='" + getModifiedByRecord() + "'" +
            "}";
    }
}
