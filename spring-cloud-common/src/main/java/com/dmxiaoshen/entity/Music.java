package com.dmxiaoshen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hzhsg on 2017/12/5.
 */
public class Music implements Serializable{
    private static final long serialVersionUID = -1026516644062592108L;

    private String name;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    private Date createTime;
    private Date updateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Music{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", publishDate=" + publishDate +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
