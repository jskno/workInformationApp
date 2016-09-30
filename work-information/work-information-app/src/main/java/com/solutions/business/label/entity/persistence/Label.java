package com.solutions.business.label.entity.persistence;

import com.solutions.entity.base.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Jose on 17/09/2016.
 */
@Entity
@Table(name = "LABEL")
@NamedQueries({
        @NamedQuery(name = Label.FIND_ALL,
            query= Label.QUERY_SQL_FIND_ALL),
        @NamedQuery(name = Label.FIND_PARENT_LABELS,
                query= Label.QUERY_SQL_FIND_PARENT_LABELS)
})
public class Label extends AbstractEntity {

    public static final String FIND_ALL = "Label.FIND_ALL";
    public static final String QUERY_SQL_FIND_ALL = "Select e From Label e Order By e.labelParent, e.order";

    public static final String FIND_PARENT_LABELS = "Label.FIND_PARENT_LABELS";
    public static final String QUERY_SQL_FIND_PARENT_LABELS = "Select e From Label e Where e.labelParent is null Order By e.order";

    private static final String BASE = "LABEL";


    @Column(name = "LABEL_TEXT")
    private String labelText;

    @Column(name = "LABEL_ORDER")
    private Integer order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LABEL_PARENT")
    private Label labelParent;

    @OneToMany(mappedBy = "labelParent")
    private List<Label> children;

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

    public Label getLabelParent() {
        return labelParent;
    }

    public void setLabelParent(Label labelParent) {
        this.labelParent = labelParent;
    }

    public List<Label> getChildren() {
        return children;
    }

    public void setChildren(List<Label> children) {
        this.children = children;
    }
}
