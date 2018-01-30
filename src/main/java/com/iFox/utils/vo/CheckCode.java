package com.iFox.utils.vo;

/**
 * Created by exphuhong
 * Date 18-1-29.
 * Start
 */
public class CheckCode {
    private String code;
    private Long createTime;
    private Long expTime;

    public CheckCode(String code, Long createTime, Long expTime) {
        this.code = code;
        this.createTime = createTime;
        this.expTime = expTime;
    }

    public CheckCode() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
