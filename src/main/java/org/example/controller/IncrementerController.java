package org.example.controller;

import org.example.service.IncrementerService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("incrementer")
@ApplicationScoped
public class IncrementerController {

    @Inject
    private IncrementerService incrementerService;

    @GET
    @Path("number")
    public Response getNumber() {

        return Response.ok().entity(Integer.toString(incrementerService.getNumber()) + "\n").build();
    }

    @GET
    @Path("increment")
    public Response incrementNumber() {
        incrementerService.incrementNumber();

        return Response.ok().build();
    }

    @GET
    @Path("setMax")
    public Response setMaximumValue(@QueryParam("maxVal") int maximumValue) {
        incrementerService.setMaximumValue(maximumValue);

        return Response.ok().build();
    }

}
