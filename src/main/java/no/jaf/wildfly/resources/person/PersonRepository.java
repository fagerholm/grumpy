package no.jaf.wildfly.resources.person;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.Order;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;

@Stateful
public class PersonRepository {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    Person person;

    public Collection<Person> findAll() {

        Query query = em.createQuery("SELECT e FROM Person e");
        return (Collection<Person>) query.getResultList();
    }
}
