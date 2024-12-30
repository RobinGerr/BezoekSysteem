package nl.justitie.bezoeksysteem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Bezoeker {
    @Id
    @GeneratedValue
    private long id;
    private String voorNaam;
    private String achterNaam;
    private LocalDate geboorteDatum;
    private String woonPlaats;
    private long bsn;
    @OneToMany(mappedBy = "bezoeker")
    private List<Bezoek> bezoeken;

    public Bezoeker(String voorNaam, String achterNaam, LocalDate geboorteDatum, String woonPlaats, long bsn) {
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.geboorteDatum = geboorteDatum;
        this.woonPlaats = woonPlaats;
        this.bsn = bsn;
    }

    public Bezoeker(String voorNaam, String achterNaam, LocalDate geboorteDatum, String woonPlaats) {
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.geboorteDatum = geboorteDatum;
        this.woonPlaats = woonPlaats;
    }

    public Bezoeker() {

    }

    // getters
    public long getId() {
        return id;
    }
    public String getVoorNaam() {
        return voorNaam;
    }
    public String getAchterNaam() {
        return achterNaam;
    }
    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }
    public String getWoonPlaats() {
        return woonPlaats;
    }
    public long getBsn() {
        return bsn;
    }

    // setters
    public void setBsn(long bsn) {
        this.bsn = bsn;
    }
}
