package com.solutions.business.label.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jose on 24/09/2016.
 */
public class LabelsSummary {

    private List<LabelSummary> labels;

    public List<LabelSummary> getLabels() {
        if(labels == null) {
            labels = new ArrayList<>();
        }
        return labels;
    }

    public void setLabels(List<LabelSummary> labels) {
        this.labels = labels;
    }
}
