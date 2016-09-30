package com.solutions.business.label.control;

import com.solutions.business.label.entity.LabelSummary;
import com.solutions.business.label.entity.LabelsSummary;
import com.solutions.business.label.entity.persistence.Label;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Jose on 24/09/2016.
 */
@ApplicationScoped
public class LabelService {

    @Inject
    LabelRepository labelRepository;

    @Inject
    LabelMapper labelMapper;

    public LabelsSummary findAllLabels() {
        List<Label> labels = labelRepository.findAllLabels();
        return labelMapper.mapLabelsToLabelsSummary(labels);
    }

    public void saveLabel(LabelSummary labelSummary) {
        labelRepository.saveLabel(labelMapper.mapLabelSummaryToLabel(labelSummary));
    }
}
