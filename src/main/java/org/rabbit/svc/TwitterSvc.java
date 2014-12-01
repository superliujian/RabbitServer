package org.rabbit.svc;

import org.rabbit.model.*;
import org.rabbit.dblayer.*;

import javax.ws.rs.*;

@Path("/twitter")
public class TwitterSvc {

    // sub resources
    @GET
    @Path("/twitters")
    @Produces("application/json")
    // get twitters according to user credential
    public Twitter[] getTwitters(@QueryParam("access_token") String access_token) {
        System.out.println(access_token);
        Twitter[] twitters = HibernateUtil.getTwitters();
        return twitters;
    }


    @POST
    @Path("/addTwitter")
    @Consumes("application/json")
    @Produces("application/json")
    // get twitters according to user credential
    public Twitter addTwitter(Twitter twitter, @QueryParam("access_token") String access_token) {
        System.out.println(access_token);
        HibernateUtil.addTwitter(twitter);
        return twitter;
    }

    @GET
    @Path("/removeTwitter/{id}")
    @Produces("application/json")
    // get twitters according to user credential
    public boolean removeTwitter(@PathParam("id") int id, @QueryParam("access_token") String access_token) {
        System.out.println(access_token);
        Twitter twitter=new Twitter();
        twitter.setId(id);
        return HibernateUtil.removeTwitter(twitter);
    }
}