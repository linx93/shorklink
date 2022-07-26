package com.linx.shorklink.model.po;

import org.springframework.data.annotation.Id;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * url的映射关系
 *
 * @author linx
 * @since 2022/7/10 下午10:50
 */
public class UrlMap {
    @Id
    Long id;

    String shortUrl;

    String longUrl;

    String shortUrlDigest;

    String longUrlDigest;

    String compressionCode;

    String description;

    Integer urlStatus;

//    OffsetDateTime createTime;
//
//    OffsetDateTime editTime;

    String creator;

    String editor;

    Integer deleted;

    Long version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrlDigest() {
        return shortUrlDigest;
    }

    public void setShortUrlDigest(String shortUrlDigest) {
        this.shortUrlDigest = shortUrlDigest;
    }

    public String getLongUrlDigest() {
        return longUrlDigest;
    }

    public void setLongUrlDigest(String longUrlDigest) {
        this.longUrlDigest = longUrlDigest;
    }

    public String getCompressionCode() {
        return compressionCode;
    }

    public void setCompressionCode(String compressionCode) {
        this.compressionCode = compressionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUrlStatus() {
        return urlStatus;
    }

    public void setUrlStatus(Integer urlStatus) {
        this.urlStatus = urlStatus;
    }

//    public OffsetDateTime getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(OffsetDateTime createTime) {
//        this.createTime = createTime;
//    }
//
//    public OffsetDateTime getEditTime() {
//        return editTime;
//    }
//
//    public void setEditTime(OffsetDateTime editTime) {
//        this.editTime = editTime;
//    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEditor() {
        return editor;
    }


    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    public UrlMap(Long id, String shortUrl, String longUrl, String shortUrlDigest, String longUrlDigest, String compressionCode, String description, Integer urlStatus, String creator, String editor, Integer deleted, Long version) {
        this.id = id;
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.shortUrlDigest = shortUrlDigest;
        this.longUrlDigest = longUrlDigest;
        this.compressionCode = compressionCode;
        this.description = description;
        this.urlStatus = urlStatus;
        this.creator = creator;
        this.editor = editor;
        this.deleted = deleted;
        this.version = version;
    }

    boolean hasId() {
        return id != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlMap urlMap = (UrlMap) o;
        return getId().equals(urlMap.getId()) && getShortUrl().equals(urlMap.getShortUrl()) && getLongUrl().equals(urlMap.getLongUrl()) && getShortUrlDigest().equals(urlMap.getShortUrlDigest()) && getLongUrlDigest().equals(urlMap.getLongUrlDigest()) && getCompressionCode().equals(urlMap.getCompressionCode()) && getDescription().equals(urlMap.getDescription()) && getUrlStatus().equals(urlMap.getUrlStatus()) && getCreator().equals(urlMap.getCreator()) && getEditor().equals(urlMap.getEditor()) && getDeleted().equals(urlMap.getDeleted()) && getVersion().equals(urlMap.getVersion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getShortUrl(), getLongUrl(), getShortUrlDigest(), getLongUrlDigest(), getCompressionCode(), getDescription(), getUrlStatus(), getCreator(), getEditor(), getDeleted(), getVersion());
    }

    @Override
    public String toString() {
        return "UrlMap{" +
                "id=" + id +
                ", shortUrl='" + shortUrl + '\'' +
                ", longUrl='" + longUrl + '\'' +
                ", shortUrlDigest='" + shortUrlDigest + '\'' +
                ", longUrlDigest='" + longUrlDigest + '\'' +
                ", compressionCode='" + compressionCode + '\'' +
                ", description='" + description + '\'' +
                ", urlStatus=" + urlStatus +
                ", creator='" + creator + '\'' +
                ", editor='" + editor + '\'' +
                ", deleted=" + deleted +
                ", version=" + version +
                '}';
    }
}
