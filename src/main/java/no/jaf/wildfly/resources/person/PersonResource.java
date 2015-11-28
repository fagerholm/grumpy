package no.jaf.wildfly.resources.person;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/person")
@ApplicationPath("/resources")
public class PersonResource extends Application{

    @Context
    private UriInfo context;

    public PersonResource() {
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Person getHtml() {

        Person person = new Person();
        person.setId(1);
        person.setFirstName("Jon");
        person.setLastName("Fagerholm");
        return person;
    }

}
