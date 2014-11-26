package svc;


import model.Student;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/xmlsvc")
public class StudentSvc {

    @GET
    @Path("/student/{name}")
    @Produces("application/xml")
    public Student getStudent(@PathParam("name") String name){
        Student student=new Student(1,name,"John",22);
        return student;
    }
}
