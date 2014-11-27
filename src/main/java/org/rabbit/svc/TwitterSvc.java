package org.rabbit.svc;

import org.rabbit.model.*;
import org.rabbit.dblayer.*;

import javax.ws.rs.*;

@Path("/twitter")
public class TwitterSvc {

    @POST
    @Path("/twitters")
    @Consumes("application/json")
    @Produces("application/json")
    // get twitters according to user credential
    public Twitter[] getTwitters(User user) {
        Twitter[] twitters = HibernateUtil.getTwitters();
        return twitters;
    }


    @POST
    @Path("/addTwitter")
    @Consumes("application/json")
    @Produces("application/json")
    // get twitters according to user credential
    public Twitter addTwitter(Twitter twitter) {
        HibernateUtil.addTwitter(twitter);
        return twitter;
    }

    @GET
    @Path("/removeTwitter/{id}")
    @Produces("application/json")
    // get twitters according to user credential
    public boolean removeTwitter(@PathParam("id") int id) {
        Twitter twitter=new Twitter();
        twitter.setId(id);
        return HibernateUtil.removeTwitter(twitter);
    }
}