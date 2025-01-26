package nl.justitie.bezoeksysteem;

import nl.justitie.bezoeksysteem.model.Bezoek;
import nl.justitie.bezoeksysteem.model.Bezoeker;

import nl.justitie.bezoeksysteem.model.Gedetineerde;
import nl.justitie.bezoeksysteem.repository.BezoekRepository;
import nl.justitie.bezoeksysteem.repository.BezoekerRepository;
import nl.justitie.bezoeksysteem.repository.GedetineerdeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BezoeksysteemApplicationTests {

	@Autowired
	private BezoekerRepository bezoekerRepository;

	@Autowired
	private BezoekRepository bezoekRepository;

	@Autowired
	private GedetineerdeRepository gedetineerdeRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void should_create_bezoeker() throws Exception {
		Bezoeker bezoeker1 = new Bezoeker("Gerard", "de Lier", LocalDate.of(2002, 10, 3), "Den Haag");
		bezoekerRepository.save(bezoeker1);

		List<Bezoeker> bezoekers = bezoekerRepository.findAllByAchterNaam("de Lier");

		if (!bezoekers.isEmpty()) {
			Bezoeker lastBezoeker = bezoekers.get(bezoekers.size() - 1);

			assertEquals("de Lier", lastBezoeker.getAchterNaam(), "The last name should match");
			assertEquals("Gerard", lastBezoeker.getVoorNaam(), "The first name should match");
			assertEquals(LocalDate.of(2002, 10, 3), lastBezoeker.getGeboorteDatum(), "The birth date should match");
			assertEquals("Den Haag", lastBezoeker.getWoonPlaats(), "The residence should match");
		}
	}

	@Test
	public void should_create_bezoek() throws Exception {
		Bezoeker bezoeker1 = new Bezoeker("Gerard", "de Lier", LocalDate.of(2002, 10, 3), "Den Haag");
		bezoekerRepository.save(bezoeker1);
		Gedetineerde gedetineerde1 = new Gedetineerde("Jan", "de Vries", "A", 1);
		gedetineerdeRepository.save(gedetineerde1);

		Bezoek bezoek1 = new Bezoek(LocalDate.of(2025, 2, 1), LocalTime.parse("10:30:00"));
		bezoek1.setBezoeker(bezoeker1);
		bezoek1.setGedetineerde(gedetineerde1);
		bezoekRepository.save(bezoek1);

		List<Bezoek> bezoeken = bezoekRepository.findByDatumOrderByTijdAsc(LocalDate.of(2025, 2, 1));

		if (!bezoeken.isEmpty()) {
			Bezoek lastBezoek = bezoeken.get(bezoeken.size() - 1);

			assertEquals(LocalDate.of(2025, 2, 1), lastBezoek.getDatum(), "The date should match");
			assertEquals(LocalTime.parse("10:30:00"), lastBezoek.getTijd(), "The time should match");
			assertEquals(gedetineerde1.getRegistratieNummer(), lastBezoek.getGedetineerde().getRegistratieNummer(), "The gedetineerde should match");
			assertEquals(bezoeker1.getId(), lastBezoek.getBezoeker().getId(), "The bezoeker should match");
		}
	}

}



