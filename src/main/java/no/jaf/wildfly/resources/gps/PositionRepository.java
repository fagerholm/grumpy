package no.jaf.wildfly.resources.gps;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Stateless
public class PositionRepository {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    public void persist(Position position) {

        em.persist(position);
    }

    public Collection<Position> getAll() {

        System.out.println("Er i repository");
        Query query = em.createQuery("SELECT e FROM Position e");
        return (Collection<Position>) query.getResultList();

    }


    public Collection<Position> getLatestPositions() {

        Query query = em.createQuery("SELECT e FROM Position e WHERE e.millis = (select max(e1.millis) from Position e1 where e1.user = e.user)");
        return (Collection<Position>) query.getResultList();

    }

}