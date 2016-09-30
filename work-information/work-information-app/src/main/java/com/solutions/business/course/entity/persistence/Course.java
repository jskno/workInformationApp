package com.solutions.business.course.entity.persistence;

import com.solutions.business.base.entity.persistence.AbstractWorkInfoEntity;
import com.solutions.business.label.entity.persistence.Label;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

/**
 * Created by Jose on 17/09/2016.
 */
@Entity
@Table(name = "COURSE")
public class Course extends AbstractWorkInfoEntity {

    private static final String BASE = "LOGIN";

    @Column(name = "TEACHER")
    private String teacher;

    @Column(name = "DURATION")
    private Integer duration;

    @Column(name = "STARTING_DATE")
    private Date startingDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "CENTER")
    @NotNull
    private String center;

    @Column(name = "LINK")
    private String link;

    @Column(name = "CONTENT")
    private String content;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "COURSE_LABELS", inverseJoinColumns = {
            @JoinColumn(name = "LABEL_ID", nullable = false) }, joinColumns = {
                @JoinColumn(name = "COURSE_ID", nullable = false)
    })
    private List<Label> labels;

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
