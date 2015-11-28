package no.jaf.wildfly.resources.vote;

import no.jaf.wildfly.resources.person.Person;
import no.jaf.wildfly.resources.person.PersonRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;

@Path("/vote")
@ApplicationPath("/resources")
public class VoteResource extends Application {

    @Context
    private UriInfo context;

    @Inject
    VoteRepository voteRepository;

    public VoteResource() {
    }

    @PUT
    public void vote(Vote vote) {

        voteRepository.save(vote);
    }
}