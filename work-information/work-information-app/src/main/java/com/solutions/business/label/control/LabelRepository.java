package com.solutions.business.label.control;

import com.solutions.business.label.entity.persistence.Label;
import com.solutions.business.label.entity.persistence.Label_;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Jose on 24/09/2016.
 */
@ApplicationScoped
public class LabelRepository {

    @Inject
    EntityManager em;

    @Inject
    Logger logger;

    // Order by parent NULLS FIRST is not possible using Critteria, so I resort to JPQL
    public List<Label> findAllLabelsCriteria() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Label> cq = cb.createQuery(Label.class);
        Root<Label> labelRoot = cq.from(Label.class);

        cq.select(labelRoot);
        cq.orderBy(cb.desc(labelRoot.get(Label_.labelParent)), cb.asc(labelRoot.get(Label_.order)));
        final List<Label> result = em.createQuery(cq).getResultList();
        return result;
    }

    // Order by parent NULLS FIRST and order using JPQL
    public List<Label> findAllLabels() {
//        Query query = em.createNamedQuery(Label.FIND_ALL);
        Query query = em.createNamedQuery(Label.FIND_PARENT_LABELS);
        List<Label> labels = query.getResultList();
        return labels;
    }

    public void saveLabel(Label label) {
        em.persist(label);
    }
}
