package com.solutions.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;


/**
 * Created by Jose on 18/09/2016.
 */
@ApplicationScoped
public class LogProvider {

    @Produces
    public Logger produceLogger(final InjectionPoint injectionPoint) {
        Bean<?> bean = injectionPoint.getBean();
        if(bean != null) {
            return LoggerFactory.getLogger(bean.getBeanClass());
        }
        final Class clazz = injectionPoint.getMember().getDeclaringClass();
        return getLogger(clazz);
    }

    public static Logger getLogger(final Class clazz) { return LoggerFactory.getLogger(clazz); }
}
