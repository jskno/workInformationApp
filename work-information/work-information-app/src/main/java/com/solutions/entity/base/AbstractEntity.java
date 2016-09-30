package com.solutions.entity.base;

import com.solutions.entity.listener.EntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jose on 17/09/2016.
 */
@MappedSuperclass
@EntityListeners(EntityListener.class)
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Version
    @Column(name = "VERSION")
    @NotNull
    protected Long version;

    @Column(name = "CREATED_AT", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    protected Date createdAt;

    @Column(name = "CREATED_BY", updatable = false)
    @NotNull
    protected String createdBy;

    @Column(name = "MODIFIED_AT", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    protected Date modifiedAt;

    @Column(name = "MODIFIED_BY", updatable = false)
    @NotNull
    protected String modifiedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
