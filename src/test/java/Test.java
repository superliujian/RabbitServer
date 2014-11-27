import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.rabbit.model2.Person;

// TODO: WHY DOESN'T WORK in Mac?
// Reference: http://jlunaquiroga.blogspot.jp/2014/01/restful-web-services-with-jetty-and.html
public class Test {
    public static void main(String[] args) {
        Client client = Client.create();
        //Get
        WebResource webResource = client.resource("http://localhost:8080/person/getPerson");
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        Person output = response.getEntity(Person.class);//Get the object from the response
        System.out.println("Output json client .... \n");
        System.out.println(output);

        //Post
        output.setName("Goodman");
        webResource = client.resource("http://localhost:8080/person/postPerson");
        webResource.accept("application/json").post(ClientResponse.class, output);
    }
}
