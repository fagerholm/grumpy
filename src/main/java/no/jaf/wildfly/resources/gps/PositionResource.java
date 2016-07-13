package no.jaf.wildfly.resources.gps;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.util.Collection;

@Path("/gps")
@ApplicationPath("/resources")
public class PositionResource extends Application {

    @Context
    private UriInfo context;

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    @Inject
    PositionRepository positionRepository;


    public PositionResource() {
    }

/*
    @PUT
    @Path("/{user}")
    public Response uploadCoordinates(@PathParam("user") String user, @QueryParam("lat") String latitude, @QueryParam("lon") String longitude, @QueryParam("t") String millis ) throws IOException {

        Position position = new Position();
        position.setLatitude(latitude);
        position.setLongitude(longitude);
        position.setMillis(millis);
        position.setUser(user);

        em.persist(position);

        return Response.status(200).build();
    }
*/

    @GET
    @Path("/{user}")
    public Response uploadCoordinates(@PathParam("user") String user, @QueryParam("lat") String latitude, @QueryParam("lon") String longitude, @QueryParam("t") String millis ) throws IOException {

        Position position = new Position();
        position.setLatitude(latitude);
        position.setLongitude(longitude);
        position.setMillis(millis);
        position.setUser(user);

        positionRepository.persist(position);

        return Response.status(200).build();
    }

    @GET
    @Path("/positions")
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Position> getPositions() {

        return positionRepository.getAll();
    }

    @GET
    @Path("/report")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getPositions(@QueryParam("lat") String latitude, @QueryParam("lon") String longitude, @QueryParam("t") String millis) {

        Position position = new Position();
        position.setLatitude(latitude);
        position.setLongitude(longitude);
        position.setMillis(millis);
        position.setUser("test");

        positionRepository.persist(position);
        return Response.ok().build();
    }

}
