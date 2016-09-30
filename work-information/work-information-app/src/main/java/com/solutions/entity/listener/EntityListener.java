package com.solutions.entity.listener;

import com.solutions.common.datetime.WorkInfoTimeZone;
import com.solutions.entity.base.AbstractEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by Jose on 17/09/2016.
 */
public class EntityListener {

    @PrePersist
    public void onCreate(final AbstractEntity entity) {
        final String userUID = getUID();
//        final LocalDateTime currentDate = LocalDateTime.now();
        final Date currentDate = new Date();
        entity.setCreatedAt(currentDate);
        entity.setCreatedBy(userUID);
        entity.setModifiedAt(currentDate);
        entity.setModifiedBy(userUID);
    }

    @PreUpdate
    public void onUpdate(final AbstractEntity entity) {
        final String userUID = getUID();
//        final LocalDateTime currentDate = LocalDateTime.now();
        final Date currentDate = new Date();
        entity.setModifiedAt(currentDate);
        entity.setModifiedBy(userUID);
    }

    private String getUID() {
        return "Jose";
    }
}
