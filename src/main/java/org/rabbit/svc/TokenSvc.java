package org.rabbit.svc;

import org.rabbit.model.User;

import javax.ws.rs.*;

@Path("/token")
public class TokenSvc {
    @POST
    @Path("/postToken")
    @Produces("text/plain")
    @Consumes("application/json")
    public String postToken(User user) {
        if (user.getName().isEmpty() || user.getPassword().isEmpty()) {
            return "";
        }

        if (user.getName().equals("John")) {
            return "123456";
        }

        return "";
    }

//    @GET
//    @Path("/getToken")
//    @Produces("application/json")
//    public User getToken(){
//
//        User user=new User();
//        user.setName("John");
//        user.setPassword("12345");
//
//        return user;
//    }
}
