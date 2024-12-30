package nl.justitie.bezoeksysteem.model;

import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Gedetineerde {
    @Id
    @GeneratedValue
    private long registratieNummer;
    private String voorNaam;
    private String achterNaam;
    private String afdeling;
    private int celNummer;
    @OneToMany(mappedBy = "gedetineerde")
    private List<Bezoek> bezoeken;


    // constructor
    public Gedetineerde(String voorNaam, String achterNaam, String afdeling, int celNummer) {
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.afdeling = afdeling;
        this.celNummer = celNummer;
    }

    public Gedetineerde() {

    }

    // getters
    public long getRegistratieNummer() {
        return registratieNummer;
    }

    public String getVoorNaam() {
        return voorNaam;
    }
    public String getAchterNaam() {
        return achterNaam;
    }
    public String getAfdeling() {
        return afdeling;
    }
    public int getCelNummer() {
        return celNummer;
    }
}

