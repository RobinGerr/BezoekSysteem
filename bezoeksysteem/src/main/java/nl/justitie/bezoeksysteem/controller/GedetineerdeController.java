package nl.justitie.bezoeksysteem.controller;

import nl.justitie.bezoeksysteem.model.Gedetineerde;
import nl.justitie.bezoeksysteem.repository.GedetineerdeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gedetineerde")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class GedetineerdeController {
    GedetineerdeRepository gedetineerdeRepository;

    public GedetineerdeController(GedetineerdeRepository repository) {
        this.gedetineerdeRepository = repository;
    }

    @GetMapping("/{afdeling}")
    public List<Gedetineerde> getGedetineerde(@PathVariable String afdeling) {
        return gedetineerdeRepository.findAllByAfdeling(afdeling);
    }

    @GetMapping("/one/{achterNaam}")
    public List<Gedetineerde> getGedetineerdeByAchterNaam(@PathVariable String achterNaam) {
        return gedetineerdeRepository.findByAchterNaam(achterNaam);
    }

    @GetMapping("/find/{registratieNummer}")
    public Optional<Gedetineerde> getGedetineerdeByRegistratieNummer(@PathVariable String registratieNummer) {
        long registratieNummerLong = Long.parseLong(registratieNummer);
        return gedetineerdeRepository.findByRegistratieNummer(registratieNummerLong);
    }

}