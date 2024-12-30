package nl.justitie.bezoeksysteem;

import jakarta.annotation.PostConstruct;
import nl.justitie.bezoeksysteem.model.Bezoek;
import nl.justitie.bezoeksysteem.model.Bezoeker;
import nl.justitie.bezoeksysteem.model.Gedetineerde;
import nl.justitie.bezoeksysteem.repository.BezoekRepository;
import nl.justitie.bezoeksysteem.repository.BezoekerRepository;
import nl.justitie.bezoeksysteem.repository.GedetineerdeRepository;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DatabaseSeeder {
    BezoekRepository bezoekRepository;
    BezoekerRepository bezoekerRepository;
    GedetineerdeRepository gedetineerdeRepository;

    public DatabaseSeeder(BezoekRepository bezoekRepository, GedetineerdeRepository gedetineerdeRepository, BezoekerRepository bezoekerRepository) {
        this.bezoekRepository = bezoekRepository;
        this.bezoekerRepository = bezoekerRepository;
        this.gedetineerdeRepository = gedetineerdeRepository;
    }

    @PostConstruct
    public void seedDatabase() {
        createGedetineerdeAndBezoekers();
    }

    private void createGedetineerdeAndBezoekers() {
        if (gedetineerdeRepository.count() == 0 && bezoekerRepository.count() == 0)  {
            // Afdeling A
            Gedetineerde gedetineerde1 = new Gedetineerde("Jan", "de Vries", "A", 1);
            gedetineerdeRepository.save(gedetineerde1);
            Gedetineerde gedetineerde2 = new Gedetineerde("Willem", "de Jong", "A", 2);
            gedetineerdeRepository.save(gedetineerde2);
            Gedetineerde gedetineerde3 = new Gedetineerde("Pieter", "Jansen", "A", 3);
            gedetineerdeRepository.save(gedetineerde3);
            Gedetineerde gedetineerde4 = new Gedetineerde("Henk", "Bakker", "A", 4);
            gedetineerdeRepository.save(gedetineerde4);
            Gedetineerde gedetineerde5 = new Gedetineerde("Kees", "Visser", "A", 5);
            gedetineerdeRepository.save(gedetineerde5);
            Gedetineerde gedetineerde6 = new Gedetineerde("Johan", "Smit", "A", 6);
            gedetineerdeRepository.save(gedetineerde6);
            Gedetineerde gedetineerde7 = new Gedetineerde("Arjan", "Bos", "A", 7);
            gedetineerdeRepository.save(gedetineerde7);
            Gedetineerde gedetineerde8 = new Gedetineerde("Rik", "Mulder", "A", 8);
            gedetineerdeRepository.save(gedetineerde8);
            Gedetineerde gedetineerde9 = new Gedetineerde("Theo", "Meijer", "A", 9);
            gedetineerdeRepository.save(gedetineerde9);
            Gedetineerde gedetineerde10 = new Gedetineerde("Erik", "Dijkstra", "A", 10);
            gedetineerdeRepository.save(gedetineerde10);

            // Afdeling B
            Gedetineerde gedetineerde21 = new Gedetineerde("Sander", "van Leeuwen", "B", 1);
            gedetineerdeRepository.save(gedetineerde21);
            Gedetineerde gedetineerde22 = new Gedetineerde("Martijn", "van den Berg", "B", 2);
            gedetineerdeRepository.save(gedetineerde22);
            Gedetineerde gedetineerde23 = new Gedetineerde("Bram", "de Bruin", "B", 3);
            gedetineerdeRepository.save(gedetineerde23);
            Gedetineerde gedetineerde24 = new Gedetineerde("Jeroen", "de Wit", "B", 4);
            gedetineerdeRepository.save(gedetineerde24);
            Gedetineerde gedetineerde25 = new Gedetineerde("Patrick", "van Vliet", "B", 5);
            gedetineerdeRepository.save(gedetineerde25);
            Gedetineerde gedetineerde26 = new Gedetineerde("Casper", "de Koning", "B", 6);
            gedetineerdeRepository.save(gedetineerde26);
            Gedetineerde gedetineerde27 = new Gedetineerde("Niels", "van Dam", "B", 7);
            gedetineerdeRepository.save(gedetineerde27);
            Gedetineerde gedetineerde28 = new Gedetineerde("Daan", "Verhoeven", "B", 8);
            gedetineerdeRepository.save(gedetineerde28);
            Gedetineerde gedetineerde29 = new Gedetineerde("Wouter", "Peeters", "B", 9);
            gedetineerdeRepository.save(gedetineerde29);
            Gedetineerde gedetineerde30 = new Gedetineerde("Roy", "Scholten", "B", 10);
            gedetineerdeRepository.save(gedetineerde30);

            // Afdeling C
            Gedetineerde gedetineerde41 = new Gedetineerde("Mike", "de Graaf", "C", 1);
            gedetineerdeRepository.save(gedetineerde41);
            Gedetineerde gedetineerde42 = new Gedetineerde("Erwin", "van den Heuvel", "C", 2);
            gedetineerdeRepository.save(gedetineerde42);
            Gedetineerde gedetineerde43 = new Gedetineerde("Danny", "Wolters", "C", 3);
            gedetineerdeRepository.save(gedetineerde43);
            Gedetineerde gedetineerde44 = new Gedetineerde("Hans", "Peters", "C", 4);
            gedetineerdeRepository.save(gedetineerde44);
            Gedetineerde gedetineerde45 = new Gedetineerde("Gerard", "de Lange", "C", 5);
            gedetineerdeRepository.save(gedetineerde45);
            Gedetineerde gedetineerde46 = new Gedetineerde("Robert", "Koster", "C", 6);
            gedetineerdeRepository.save(gedetineerde46);
            Gedetineerde gedetineerde47 = new Gedetineerde("Sebastiaan", "Kuijpers", "C", 7);
            gedetineerdeRepository.save(gedetineerde47);
            Gedetineerde gedetineerde48 = new Gedetineerde("Nico", "van der Meer", "C", 8);
            gedetineerdeRepository.save(gedetineerde48);
            Gedetineerde gedetineerde49 = new Gedetineerde("Maurice", "Evers", "C", 9);
            gedetineerdeRepository.save(gedetineerde49);
            Gedetineerde gedetineerde50 = new Gedetineerde("Edwin", "Boers", "C", 10);
            gedetineerdeRepository.save(gedetineerde50);

            // Bezoekers
            Bezoeker bezoeker1 = new Bezoeker("Gerard", "de Lier", LocalDate.of(2002, 10, 3), "Den Haag");
            bezoekerRepository.save(bezoeker1);
            Bezoeker bezoeker2 = new Bezoeker("Sofie", "van Dam", LocalDate.of(1995, 5, 15), "Rotterdam");
            bezoekerRepository.save(bezoeker2);
            Bezoeker bezoeker3 = new Bezoeker("Kees", "Jansen", LocalDate.of(1980, 12, 23), "Amsterdam");
            bezoekerRepository.save(bezoeker3);
            Bezoeker bezoeker4 = new Bezoeker("Lotte", "Vermeer", LocalDate.of(1990, 8, 9), "Utrecht");
            bezoekerRepository.save(bezoeker4);
            Bezoeker bezoeker5 = new Bezoeker("Martijn", "de Boer", LocalDate.of(2000, 3, 19), "Eindhoven");
            bezoekerRepository.save(bezoeker5);
            Bezoeker bezoeker6 = new Bezoeker("Hanna", "Schouten", LocalDate.of(1978, 11, 11), "Groningen");
            bezoekerRepository.save(bezoeker6);
            Bezoeker bezoeker7 = new Bezoeker("Willem", "van Vliet", LocalDate.of(1993, 2, 28), "Zwolle");
            bezoekerRepository.save(bezoeker7);
            Bezoeker bezoeker8 = new Bezoeker("Emma", "Hoekstra", LocalDate.of(2001, 7, 14), "Tilburg");
            bezoekerRepository.save(bezoeker8);
            Bezoeker bezoeker9 = new Bezoeker("Rik", "Kramer", LocalDate.of(1985, 6, 5), "Nijmegen");
            bezoekerRepository.save(bezoeker9);
            Bezoeker bezoeker10 = new Bezoeker("Laura", "van Leeuwen", LocalDate.of(1998, 4, 20), "Maastricht");
            bezoekerRepository.save(bezoeker10);
            Bezoeker bezoeker11 = new Bezoeker("Tom", "Visser", LocalDate.of(1975, 9, 30), "Den Bosch");
            bezoekerRepository.save(bezoeker11);
            Bezoeker bezoeker12 = new Bezoeker("Daan", "Kuipers", LocalDate.of(1988, 1, 17), "Alkmaar");
            bezoekerRepository.save(bezoeker12);
            Bezoeker bezoeker13 = new Bezoeker("Iris", "Peeters", LocalDate.of(1999, 10, 12), "Leeuwarden");
            bezoekerRepository.save(bezoeker13);
            Bezoeker bezoeker14 = new Bezoeker("Mark", "de Wit", LocalDate.of(1994, 12, 25), "Apeldoorn");
            bezoekerRepository.save(bezoeker14);
            Bezoeker bezoeker15 = new Bezoeker("Sanne", "Timmermans", LocalDate.of(1982, 3, 8), "Dordrecht");
            bezoekerRepository.save(bezoeker15);
            Bezoeker bezoeker16 = new Bezoeker("Joost", "van der Meer", LocalDate.of(1997, 5, 21), "Amersfoort");
            bezoekerRepository.save(bezoeker16);
            Bezoeker bezoeker17 = new Bezoeker("Lisanne", "Blom", LocalDate.of(2003, 9, 4), "Arnhem");
            bezoekerRepository.save(bezoeker17);
            Bezoeker bezoeker18 = new Bezoeker("Pieter", "Molenaar", LocalDate.of(1970, 7, 7), "Haarlem");
            bezoekerRepository.save(bezoeker18);
            Bezoeker bezoeker19 = new Bezoeker("Bart", "Roos", LocalDate.of(1987, 11, 22), "Vlissingen");
            bezoekerRepository.save(bezoeker19);
            Bezoeker bezoeker20 = new Bezoeker("Kim", "Scholten", LocalDate.of(1996, 6, 3), "Enschede");
            bezoekerRepository.save(bezoeker20);

            createBezoeken(gedetineerde1, gedetineerde2, gedetineerde3, bezoeker1, bezoeker2, bezoeker3);
        }
    }

    public void createBezoeken(Gedetineerde gedetineerde1, Gedetineerde gedetineerde2, Gedetineerde gedetineerde3, Bezoeker bezoeker1, Bezoeker bezoeker2, Bezoeker bezoeker3) {
        if (bezoekRepository.count() == 0) {
            // Bezoeken
            Bezoek bezoek1 = new Bezoek(LocalDate.of(2024, 12, 30), LocalTime.parse("10:30:00"));
            bezoek1.setBezoeker(bezoeker1);
            bezoek1.setGedetineerde(gedetineerde1);
            bezoekRepository.save(bezoek1);

            Bezoek bezoek2 = new Bezoek(LocalDate.of(2024, 12, 31), LocalTime.parse("11:00:00"));
            bezoek2.setBezoeker(bezoeker2);
            bezoek2.setGedetineerde(gedetineerde2);
            bezoekRepository.save(bezoek2);

            Bezoek bezoek3 = new Bezoek(LocalDate.of(2025, 1, 2), LocalTime.parse("14:00:00"));
            bezoek3.setBezoeker(bezoeker3);
            bezoek3.setGedetineerde(gedetineerde3);
            bezoekRepository.save(bezoek3);

            Bezoek bezoek4 = new Bezoek(LocalDate.of(2025, 1, 3), LocalTime.parse("13:00:00"));
            bezoek4.setBezoeker(bezoeker1);
            bezoek4.setGedetineerde(gedetineerde2);
            bezoekRepository.save(bezoek4);

            Bezoek bezoek5 = new Bezoek(LocalDate.of(2025, 1, 4), LocalTime.parse("10:45:00"));
            bezoek5.setBezoeker(bezoeker2);
            bezoek5.setGedetineerde(gedetineerde3);
            bezoekRepository.save(bezoek5);

            Bezoek bezoek6 = new Bezoek(LocalDate.of(2025, 1, 5), LocalTime.parse("13:15:00"));
            bezoek6.setBezoeker(bezoeker3);
            bezoek6.setGedetineerde(gedetineerde1);
            bezoekRepository.save(bezoek6);

            Bezoek bezoek7 = new Bezoek(LocalDate.of(2025, 1, 6), LocalTime.parse("12:30:00"));
            bezoek7.setBezoeker(bezoeker1);
            bezoek7.setGedetineerde(gedetineerde3);
            bezoekRepository.save(bezoek7);

            Bezoek bezoek8 = new Bezoek(LocalDate.of(2025, 1, 7), LocalTime.parse("15:30:00"));
            bezoek8.setBezoeker(bezoeker2);
            bezoek8.setGedetineerde(gedetineerde1);
            bezoekRepository.save(bezoek8);

            Bezoek bezoek9 = new Bezoek(LocalDate.of(2025, 1, 8), LocalTime.parse("10:15:00"));
            bezoek9.setBezoeker(bezoeker3);
            bezoek9.setGedetineerde(gedetineerde2);
            bezoekRepository.save(bezoek9);

            Bezoek bezoek10 = new Bezoek(LocalDate.of(2025, 1, 9), LocalTime.parse("14:30:00"));
            bezoek10.setBezoeker(bezoeker1);
            bezoek10.setGedetineerde(gedetineerde2);
            bezoekRepository.save(bezoek10);

            Bezoek bezoek11 = new Bezoek(LocalDate.of(2025, 1, 10), LocalTime.parse("11:45:00"));
            bezoek11.setBezoeker(bezoeker2);
            bezoek11.setGedetineerde(gedetineerde3);
            bezoekRepository.save(bezoek11);

            Bezoek bezoek12 = new Bezoek(LocalDate.of(2025, 1, 11), LocalTime.parse("16:30:00"));
            bezoek12.setBezoeker(bezoeker3);
            bezoek12.setGedetineerde(gedetineerde1);
            bezoekRepository.save(bezoek12);

            Bezoek bezoek13 = new Bezoek(LocalDate.of(2025, 1, 12), LocalTime.parse("09:15:00"));
            bezoek13.setBezoeker(bezoeker1);
            bezoek13.setGedetineerde(gedetineerde3);
            bezoekRepository.save(bezoek13);

            Bezoek bezoek14 = new Bezoek(LocalDate.of(2025, 1, 13), LocalTime.parse("13:30:00"));
            bezoek14.setBezoeker(bezoeker2);
            bezoek14.setGedetineerde(gedetineerde1);
            bezoekRepository.save(bezoek14);

            Bezoek bezoek15 = new Bezoek(LocalDate.of(2025, 1, 14), LocalTime.parse("10:00:00"));
            bezoek15.setBezoeker(bezoeker3);
            bezoek15.setGedetineerde(gedetineerde2);
            bezoekRepository.save(bezoek15);

            Bezoek bezoek16 = new Bezoek(LocalDate.now(), LocalTime.parse("10:00:00"));
            bezoek16.setBezoeker(bezoeker3);
            bezoek16.setGedetineerde(gedetineerde2);
            bezoekRepository.save(bezoek16);

            Bezoek bezoek17 = new Bezoek(LocalDate.now(), LocalTime.parse("10:00:00"));
            bezoek17.setBezoeker(bezoeker1);
            bezoek17.setGedetineerde(gedetineerde1);
            bezoekRepository.save(bezoek17);

            Bezoek bezoek18 = new Bezoek(LocalDate.now(), LocalTime.parse("10:00:00"));
            bezoek18.setBezoeker(bezoeker2);
            bezoek18.setGedetineerde(gedetineerde3);
            bezoekRepository.save(bezoek18);
        }
    }
}
