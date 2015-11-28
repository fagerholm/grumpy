package no.jaf.wildfly.resources.vote;

import no.jaf.wildfly.resources.person.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VoteRepository {

    @PersistenceContext(unitName = "primary")
    EntityManager em;

    Person person;

    public void save(Vote vote) {

        em.persist(vote);
    }
}