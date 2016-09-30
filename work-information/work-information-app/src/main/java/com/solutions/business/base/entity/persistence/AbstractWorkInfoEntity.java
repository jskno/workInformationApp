package com.solutions.business.base.entity.persistence;

import com.solutions.entity.base.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Jose on 17/09/2016.
 */
@MappedSuperclass
public abstract class AbstractWorkInfoEntity extends AbstractEntity {

    @Column(name = "TITLE")
    @NotNull
    protected String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
