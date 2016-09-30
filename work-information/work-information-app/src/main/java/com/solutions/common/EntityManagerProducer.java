package com.solutions.common;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Jose on 19/09/2016.
 */
@ApplicationScoped
public class EntityManagerProducer {

    @Produces
    @PersistenceContext(unitName = "workInfo")
    private EntityManager em;
}
