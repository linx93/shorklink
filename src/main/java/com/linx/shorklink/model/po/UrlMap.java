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
public record UrlMap(@Id Long id,

              String shortUrl,

              String longUrl,

              String shortUrlDigest,

              String longUrlDigest,

              String compressionCode,

              String description,

              Integer urlStatus,

              OffsetDateTime createTime,

              OffsetDateTime editTime,

              String creator,

              String editor,

              Integer deleted,

              Long version) {


    boolean hasId() {
        return id != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UrlMap urlMap = (UrlMap) o;
        return Objects.equals(id, urlMap.id) && Objects.equals(shortUrl, urlMap.shortUrl) && Objects.equals(longUrl, urlMap.longUrl) && Objects.equals(shortUrlDigest, urlMap.shortUrlDigest) && Objects.equals(longUrlDigest, urlMap.longUrlDigest) && Objects.equals(compressionCode, urlMap.compressionCode) && Objects.equals(description, urlMap.description) && Objects.equals(urlStatus, urlMap.urlStatus) && Objects.equals(createTime, urlMap.createTime) && Objects.equals(editTime, urlMap.editTime) && Objects.equals(creator, urlMap.creator) && Objects.equals(editor, urlMap.editor) && Objects.equals(deleted, urlMap.deleted) && Objects.equals(version, urlMap.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shortUrl, longUrl, shortUrlDigest, longUrlDigest, compressionCode, description, urlStatus, createTime, editTime, creator, editor, deleted, version);
    }

}
