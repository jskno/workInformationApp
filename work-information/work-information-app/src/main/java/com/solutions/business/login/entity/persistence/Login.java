package com.solutions.business.login.entity.persistence;

import com.solutions.business.base.entity.persistence.AbstractWorkInfoEntity;
import com.solutions.business.label.entity.persistence.Label;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Jose on 17/09/2016.
 */
@Entity
@Table(name = "LOGIN")
public class Login extends AbstractWorkInfoEntity {

    private static final String BASE = "LOGIN";

    @Column(name = "USERNAME")
    @NotNull
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "URL")
    @NotNull
    private String url;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "LOGIN_LABELS", inverseJoinColumns = {
            @JoinColumn(name = "LABEL_ID", nullable = false) }, joinColumns = {
            @JoinColumn(name = "LOGIN_ID", nullable = false)
    })
    private List<Label> labels;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
