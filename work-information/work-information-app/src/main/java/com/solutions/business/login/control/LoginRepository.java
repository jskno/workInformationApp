package com.solutions.business.login.control;

import com.solutions.business.login.entity.persistence.Login;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Jose on 18/09/2016.
 */
@ApplicationScoped
public class LoginRepository {

    @Inject
    EntityManager em;

    @Inject
    Logger logger;

    public void save(Login login) {
        em.persist(login);
    }

    public void update(Login login) {

    }

    public List<Login> findAllLogins() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Login> cq = cb.createQuery(Login.class);
        final Root<Login> login = cq.from(Login.class);

        cq.select(login);
//        cq.orderBy()
        final List<Login> result = em.createQuery(cq).getResultList();
        return result;
    }
}
