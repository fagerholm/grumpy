package no.jaf.wildfly.resources.person;


import no.jaf.wildfly.resources.vote.Vote;
import no.jaf.wildfly.resources.vote.VoteRepository;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;

@Path("/person")
@ApplicationPath("/resources")
public class PersonResource extends Application{

    @Context
    private UriInfo context;

    @Inject
    PersonRepository personRepository;
    @Inject
    VoteRepository voteRepository;

    public PersonResource() {
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Person> getHtml() {

        Vote vote = new Vote();
        vote.setId(42);
        vote.setVoter(3);
        vote.setColor(2);
        vote.setLooks(4);
        vote.setTaste(3);

        voteRepository.save(vote);

        return personRepository.findAll();


    }

}
