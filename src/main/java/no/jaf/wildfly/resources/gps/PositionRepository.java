package no.jaf.wildfly.resources.gps;

import no.jaf.wildfly.resources.person.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Stateless
public class PositionRepository {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    Person person;

    public void persist(Position position) {

        em.persist(position);
    }

    public Collection<Position> getAll() {

        Query query = em.createQuery("SELECT e FROM Position e");
        return (Collection<Position>) query.getResultList();

    }
}