package org.rabbit.svc;

import org.rabbit.model.*;
import org.rabbit.dblayer.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Path("/twitter")
public class TwitterSvc {

    // TODO: 如何设置通用方法来减少validation的代码？设计自定义annotation?
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

    // test only
    @GET
    @Path("/twitters2")
    @Produces("application/json")
    // get twitters according to user credential
    public Twitter[] getTwitters2(@Context SecurityContext sc) {

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