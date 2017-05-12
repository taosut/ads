package com.hanv.ads.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A Post.
 */
@Entity
@Table(name = "post")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

    @Size(max = 45)
    @Column(name = "page_id", length = 45)
    private String pageId;

    @Size(max = 45)
    @Column(name = "page_name", length = 45)
    private String pageName;

    @Size(max = 250)
    @Column(name = "category", length = 250)
    private String category;

    @Size(max = 250)
    @Column(name = "categories", length = 250)
    private String categories;

    @Size(max = 250)
    @Column(name = "link_", length = 250)
    private String link;

    @Size(max = 500)
    @Column(name = "picture", length = 500)
    private String picture;

    @Size(max = 500)
    @Column(name = "full_picture", length = 500)
    private String fullPicture;

    //@Max(value = 20)
    @Column(name = "share_count")
    private Long shareCount;

    //@Max(value = 20)
    @Column(name = "reactions_count")
    private Long reactionsCount;

    //@Max(value = 20)
    @Column(name = "comment_count")
    private Long commentCount;

    //@Max(value = 20)
    @Column(name = "like_count")
    private Long likeCount;

    //@Max(value = 20)
    @Column(name = "love_count")
    private Long loveCount;

    //@Max(value = 20)
    @Column(name = "wow_count")
    private Long wowCount;

    //@Max(value = 20)
    @Column(name = "haha_count")
    private Long hahaCount;

    //@Max(value = 20)
    @Column(name = "sad_count")
    private Long sadCount;

    //@Max(value = 20)
    @Column(name = "angry_count")
    private Long angryCount;

    //@Max(value = 20)
    @Column(name = "thankful_count")
    private Long thankfulCount;

    @Column(name = "created_date")
    private ZonedDateTime createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_date")
    private ZonedDateTime modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public Post message(String message) {
        this.message = message;
        return this;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPageId() {
        return pageId;
    }

    public Post pageId(String pageId) {
        this.pageId = pageId;
        return this;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public Post pageName(String pageName) {
        this.pageName = pageName;
        return this;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getCategory() {
        return category;
    }

    public Post category(String category) {
        this.category = category;
        return this;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategories() {
        return categories;
    }

    public Post categories(String categories) {
        this.categories = categories;
        return this;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getLink() {
        return link;
    }

    public Post link(String link) {
        this.link = link;
        return this;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicture() {
        return picture;
    }

    public Post picture(String picture) {
        this.picture = picture;
        return this;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFullPicture() {
        return fullPicture;
    }

    public Post fullPicture(String fullPicture) {
        this.fullPicture = fullPicture;
        return this;
    }

    public void setFullPicture(String fullPicture) {
        this.fullPicture = fullPicture;
    }

    public Long getShareCount() {
        return shareCount;
    }

    public Post shareCount(Long shareCount) {
        this.shareCount = shareCount;
        return this;
    }

    public void setShareCount(Long shareCount) {
        this.shareCount = shareCount;
    }

    public Long getReactionsCount() {
        return reactionsCount;
    }

    public Post reactionsCount(Long reactionsCount) {
        this.reactionsCount = reactionsCount;
        return this;
    }

    public void setReactionsCount(Long reactionsCount) {
        this.reactionsCount = reactionsCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public Post commentCount(Long commentCount) {
        this.commentCount = commentCount;
        return this;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public Post likeCount(Long likeCount) {
        this.likeCount = likeCount;
        return this;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getLoveCount() {
        return loveCount;
    }

    public Post loveCount(Long loveCount) {
        this.loveCount = loveCount;
        return this;
    }

    public void setLoveCount(Long loveCount) {
        this.loveCount = loveCount;
    }

    public Long getWowCount() {
        return wowCount;
    }

    public Post wowCount(Long wowCount) {
        this.wowCount = wowCount;
        return this;
    }

    public void setWowCount(Long wowCount) {
        this.wowCount = wowCount;
    }

    public Long getHahaCount() {
        return hahaCount;
    }

    public Post hahaCount(Long hahaCount) {
        this.hahaCount = hahaCount;
        return this;
    }

    public void setHahaCount(Long hahaCount) {
        this.hahaCount = hahaCount;
    }

    public Long getSadCount() {
        return sadCount;
    }

    public Post sadCount(Long sadCount) {
        this.sadCount = sadCount;
        return this;
    }

    public void setSadCount(Long sadCount) {
        this.sadCount = sadCount;
    }

    public Long getAngryCount() {
        return angryCount;
    }

    public Post angryCount(Long angryCount) {
        this.angryCount = angryCount;
        return this;
    }

    public void setAngryCount(Long angryCount) {
        this.angryCount = angryCount;
    }

    public Long getThankfulCount() {
        return thankfulCount;
    }

    public Post thankfulCount(Long thankfulCount) {
        this.thankfulCount = thankfulCount;
        return this;
    }

    public void setThankfulCount(Long thankfulCount) {
        this.thankfulCount = thankfulCount;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public Post createdDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Post createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getModifiedDate() {
        return modifiedDate;
    }

    public Post modifiedDate(ZonedDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public void setModifiedDate(ZonedDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public Post modifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        if (post.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), post.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Post{" +
            "id=" + getId() +
            ", message='" + getMessage() + "'" +
            ", pageId='" + getPageId() + "'" +
            ", pageName='" + getPageName() + "'" +
            ", category='" + getCategory() + "'" +
            ", categories='" + getCategories() + "'" +
            ", link='" + getLink() + "'" +
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
            ", createdDate='" + getCreatedDate() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", modifiedDate='" + getModifiedDate() + "'" +
            ", modifiedBy='" + getModifiedBy() + "'" +
            "}";
    }
}
