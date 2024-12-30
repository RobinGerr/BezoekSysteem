package nl.justitie.bezoeksysteem.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Bezoek {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate datum;
    private LocalTime tijd;
    @ManyToOne
//    @JoinColumn(name = "gedetineerde_id")
    private Gedetineerde gedetineerde;
    @ManyToOne
//    @JoinColumn(name = "bezoeker_id")
    private Bezoeker bezoeker;

    public Bezoek(LocalDate datum, LocalTime tijd) {
        this.datum = datum;
        this.tijd = tijd;
    }

    public Bezoek() {

    }

    // getters
    public LocalDate getDatum() {
        return datum;
    }
    public LocalTime getTijd() {
        return tijd;
    }
    public Gedetineerde getGedetineerde() {
        return gedetineerde;
    }
    public Bezoeker getBezoeker() {
        return bezoeker;
    }
    public long getId() {
        return id;
    }

    // setters
    public void setGedetineerde(Gedetineerde gedetineerde) {
        this.gedetineerde = gedetineerde;
    }
    public void setBezoeker(Bezoeker bezoeker) {
        this.bezoeker = bezoeker;
    }
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}


