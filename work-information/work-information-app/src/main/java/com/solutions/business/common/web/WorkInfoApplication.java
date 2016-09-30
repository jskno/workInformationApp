package com.solutions.business.common.web;

import com.solutions.business.label.boundary.LabelResource;
import com.solutions.business.login.boundary.LoginResource;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Jose on 20/09/2016.
 */
@ApplicationPath(WorkInfoApplication.REST_PATH)
public class WorkInfoApplication extends ResourceConfig {

    public static final String REST_PATH = "rs";

    public WorkInfoApplication() {
        packages(LoginResource.class.getPackage().getName());
        packages(LabelResource.class.getPackage().getName());

//        register(JacksonFeature.class);
    }
}
