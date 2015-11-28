package no.jaf.wildfly.resources.vote;

import javax.persistence.*;

@Entity
public class Vote {

    @Id
    @GeneratedValue
    private long id;

    @Version
    private long version;

    private long voter;

    private long taste;
    private long color;
    private long looks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public long getVoter() {
        return voter;
    }

    public void setVoter(long voter) {
        this.voter = voter;
    }

    public long getTaste() {
        return taste;
    }

    public void setTaste(long taste) {
        this.taste = taste;
    }

    public long getColor() {
        return color;
    }

    public void setColor(long color) {
        this.color = color;
    }

    public long getLooks() {
        return looks;
    }

    public void setLooks(long looks) {
        this.looks = looks;
    }
}
