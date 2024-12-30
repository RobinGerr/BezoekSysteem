package nl.justitie.bezoeksysteem.controller;

import nl.justitie.bezoeksysteem.model.Gedetineerde;
import nl.justitie.bezoeksysteem.repository.GedetineerdeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gedetineerde")
public class GedetineerdeController {
    GedetineerdeRepository gedetineerdeRepository;

    public GedetineerdeController(GedetineerdeRepository repository) {
        this.gedetineerdeRepository = repository;
    }

    @GetMapping("/{afdeling}")
    public List<Gedetineerde> getGedetineerde(@PathVariable String afdeling) {
        return gedetineerdeRepository.findAllByAfdeling(afdeling);
    }

    @GetMapping("/{achterNaam}")
    public List<Gedetineerde> getGedetineerdeByAchterNaam(@PathVariable String achterNaam) {
        return gedetineerdeRepository.findByAchterNaam(achterNaam);
    }
}
