package no.jaf.wildfly.resources.gps;

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

    public PositionResource() {
    }


    @PUT
    @Path("/{user}")
    public Response uploadCoordinates(@PathParam("user") String user, @QueryParam("lat") Long latitude, @QueryParam("lon") Long longitude, @QueryParam("t") Long millis ) throws IOException {

        Position position = new Position();
        position.setLatitude(latitude);
        position.setLongitude(longitude);
        position.setMillis(millis);
        position.setUser(user);

        em.persist(position);

        return Response.status(200).build();
    }

    @GET
    @Path("/positions")
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Position> getPositions() {

        Query query = em.createQuery("SELECT e FROM Position e");
        return (Collection<Position>) query.getResultList();
    }

}
