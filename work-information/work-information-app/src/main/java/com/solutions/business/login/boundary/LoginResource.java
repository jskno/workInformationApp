package com.solutions.business.login.boundary;

import com.solutions.business.login.control.LoginService;
import com.solutions.business.login.entity.LoginsSummary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Jose on 18/09/2016.
 */
@Path("logins")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Stateless
public class LoginResource {

    @Inject
    private LoginService loginService;

    @GET
    @Path("findAll")
    public Response findAllLogins() {
        final LoginsSummary logins = loginService.findAllLogins();
        return Response.ok("Hello WorkInfo").build();
    }
}
