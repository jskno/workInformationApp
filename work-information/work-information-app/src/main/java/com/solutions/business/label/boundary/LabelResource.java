package com.solutions.business.label.boundary;

import com.solutions.business.label.control.LabelService;
import com.solutions.business.label.entity.LabelSummary;
import com.solutions.business.label.entity.LabelsSummary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Jose on 24/09/2016.
 */
@Path(value = "labels")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class LabelResource {

    @Inject
    LabelService labelService;

    @POST
    @Path("save")
    public void saveLabel(LabelSummary labelSummary) {
        labelService.saveLabel(labelSummary);
    };

    @GET
    @Path("findAll")
    public Response findAllLabels() {
        LabelsSummary labels = labelService.findAllLabels();
        return Response.ok(labels).build();

    };
}


