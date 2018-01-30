package com.iFox.utils.vo;


import java.util.UUID;

/**
 * Created by exphuhong on 17-9-10.
 * Start
 */
public class TokenModel {
    private String name;
    private Long createTime;
    private Long expTime;
    private UUID uuid;

    public TokenModel() {
    }

    public TokenModel(String name, Long createTime, Long expTime, UUID uuid) {
        this.name = name;
        this.createTime = createTime;
        this.expTime = expTime;

        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getExpTime() {
        return expTime;
    }

    public void setExpTime(Long expTime) {
        this.expTime = expTime;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TokenModel that = (TokenModel) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (expTime != null ? !expTime.equals(that.expTime) : that.expTime != null) return false;
        return uuid != null ? uuid.equals(that.uuid) : that.uuid == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (expTime != null ? expTime.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        return result;
    }
}
