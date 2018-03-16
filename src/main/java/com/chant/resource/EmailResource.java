package com.chant.resource;

import com.chant.data.entity.Email;
import com.chant.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/entities")
@Component
public class EmailResource {
    private EmailService currSvc;

    @Autowired
    public EmailResource(EmailService curr) {
        this.currSvc = curr;
    }

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Email createNewEntity(Email em) {
        return currSvc.createNewEntity(em);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Email getEmailDetails(@PathParam("id") Long id) {
        return currSvc.findEntity(id);
    }
}
