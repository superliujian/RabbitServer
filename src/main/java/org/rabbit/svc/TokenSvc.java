/*************************************************************************************
*
* token (access_token) is the replacement of username/password,
*  but will be expired in a finite period
* Resource API need access_token passed in query_string for every request
*
 *************************************************************************************/
package org.rabbit.svc;

import org.rabbit.model.Token;

import javax.ws.rs.*;
import java.util.Date;
import java.util.UUID;

// root resources
@Path("/token")
public class TokenSvc {
    @GET
    @Produces("application/json")
    public Token get(@HeaderParam("username") String username, @HeaderParam("password") String password) {
        //TODO: hashed password
        System.out.println("username: "+username+", password: "+password);
        Token token=new Token();
        token.setAccess_token(UUID.randomUUID().toString());
        token.setExpire_in(new Date());

        //TODO: save token to a persist place, used to validation
        return token;
    }


    public Token renew(String access_token){
        //TODO: validate access_token
        // generate new token
        Token token=new Token();
        return token;
    }
}
