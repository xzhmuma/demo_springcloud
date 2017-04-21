package com.example.entity.base;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by SCC on 2017/1/3.
 */
@MappedSuperclass
public abstract class BaseEntity extends IdEntity {
    protected String createdBy;
    protected Date createdDate;
    protected String updatedBy;
    protected Date updatedDate;

    public BaseEntity() {

    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
