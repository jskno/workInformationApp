package com.solutions.business.label.control;

import com.solutions.business.label.entity.LabelSummary;
import com.solutions.business.label.entity.LabelsSummary;
import com.solutions.business.label.entity.persistence.Label;
import com.solutions.common.Pair;

import java.util.List;

/**
 * Created by Jose on 24/09/2016.
 */
public class LabelMapper {

    public LabelSummary mapLabelToLabelSummary(Label label) {
        LabelSummary labelSummary = new LabelSummary();
        labelSummary.setId(label.getId());
        labelSummary.setLabelText(label.getLabelText());
        labelSummary.setOrder(label.getOrder());
        if(label.getLabelParent() != null) {
            labelSummary.setLabelParentId(label.getLabelParent().getId());
        }
        label.getChildren().stream().forEach(labelChild -> labelSummary.getChildren().add(mapLabelToLabelSummary(labelChild)));
        return labelSummary;
    }

    public LabelsSummary mapLabelsToLabelsSummary(List<Label> labels) {
        LabelsSummary labelsSummary = new LabelsSummary();
        labels.stream().forEach(label -> labelsSummary.getLabels().add(mapLabelToLabelSummary(label)));
        return labelsSummary;
    }

    public Label mapLabelSummaryToLabel(LabelSummary labelSummary) {
        Label label = new Label();
        Label labelParent = new Label();

        label.setId(labelSummary.getId());
        label.setOrder(labelSummary.getOrder());
        label.setLabelText(labelSummary.getLabelText());
        labelSummary.getChildren().stream().forEach(labelSummaryChild -> label.getChildren().add(mapLabelSummaryToLabel(labelSummaryChild)));


        labelParent.setId(labelSummary.getLabelParentId());
        label.setLabelParent(labelParent);

        return label;
    }

}
