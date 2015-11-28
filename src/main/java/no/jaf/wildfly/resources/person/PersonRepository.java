package no.jaf.wildfly.resources.person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Stateless
public class PersonRepository {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    Person person;

    public Collection<Person> findAll() {

        Query query = em.createQuery("SELECT e FROM Person e");
        return (Collection<Person>) query.getResultList();
    }
}
