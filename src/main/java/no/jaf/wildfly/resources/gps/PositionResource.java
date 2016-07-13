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


    @GET
    @Path("/report/{user}")
    public Response uploadCoordinates(@PathParam("user") String user, @QueryParam("lat") String latitude, @QueryParam("lon") String longitude, @QueryParam("t") String millis ) throws IOException {

        if(user!= null && latitude != null && longitude != null && millis != null) {
            Position position = new Position();
            position.setLatitude(latitude);
            position.setLongitude(longitude);
            position.setMillis(millis);
            position.setUser(user);

            positionRepository.persist(position);
        }

        return Response.status(200).build();
    }

    @GET
    @Path("/positions")
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Position> getPositions() {
        System.out.println("Er i resource");

        Collection<Position> positions = positionRepository.getAll();

        System.out.println("Positions: " + positions);

        return positionRepository.getAll();
    }

}
