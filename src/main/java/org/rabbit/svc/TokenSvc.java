package org.rabbit.svc;

import javax.ws.rs.*;
import java.util.UUID;

// root resources
@Path("/token")
public class TokenSvc {
    @GET
    public String get(@HeaderParam("username") String username, @HeaderParam("password") String password) {
        System.out.println("username: "+username+", password: "+password);
        return UUID.randomUUID().toString();
    }
}
