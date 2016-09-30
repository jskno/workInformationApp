package com.solutions.business.label.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.solutions.common.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jose on 24/09/2016.
 */
public class LabelSummary {

    private Long id;
    private String labelText;
    private Integer order;
    private Long labelParentId;
    private List<LabelSummary> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Long getLabelParentId() {
        return labelParentId;
    }

    public void setLabelParentId(Long labelParentId) {
        this.labelParentId = labelParentId;
    }

    public List<LabelSummary> getChildren() {
        if(children == null) {
            children = new ArrayList<>();
        }
        return children;
    }

    public void setChildren(List<LabelSummary> children) {
        this.children = children;
    }

}
