package org.rabbit.svc;

import org.rabbit.dblayer.UserManager;
import org.rabbit.model.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/user")
public class UserSvc {

    @POST
    @Path("/register")
    @Consumes("application/json")
    @Produces("application/json")
    public User register(User user){
        user.setPassword("encrypted");
        return UserManager.addUser(user);
    }


    public void destory(User user){

    }
}
