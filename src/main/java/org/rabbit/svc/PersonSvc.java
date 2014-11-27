package org.rabbit.svc;

import org.rabbit.model2.Address;
import org.rabbit.model2.Person;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/person")
public class PersonSvc {

    @GET
    @Path("/getPerson")
    @Produces("application/json")
    public Person getPerson() {
        Person p = new Person();
        p.setName("John");
        p.setAge(13);

        Address address = new Address();
        address.setCity("Shanghai");
        address.setStreet("Nanliu Road");
        address.setZip(200000);
        p.setAddress(address);
        return p;
    }

    @POST
    @Path("/postPerson")
    public void postPerson(Person person) {
        System.out.println("Output json ...");
        System.out.println(person);
    }
}
