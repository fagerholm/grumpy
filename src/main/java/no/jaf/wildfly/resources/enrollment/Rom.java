package no.jaf.wildfly.resources.enrollment;


public class Rom {

    String navn;
    String lokasjon;
    int antallSenger;

    public Rom(String navn, String lokasjon, int antallSenger) {
        this.navn = navn;
        this.lokasjon = lokasjon;
        this.antallSenger = antallSenger;
    }

    public String getNavn() {
        return navn;
    }

    public String getLokasjon() {
        return lokasjon;
    }

    public int getAntallSenger() {
        return antallSenger;
    }
}
