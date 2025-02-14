package nl.justitie.bezoeksysteem.controller;

import nl.justitie.bezoeksysteem.model.Bezoek;
import nl.justitie.bezoeksysteem.model.Bezoeker;
import nl.justitie.bezoeksysteem.model.Gedetineerde;
import nl.justitie.bezoeksysteem.repository.BezoekRepository;
import nl.justitie.bezoeksysteem.repository.BezoekerRepository;
import nl.justitie.bezoeksysteem.repository.GedetineerdeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bezoek")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE} )
public class BezoekController {
    BezoekRepository bezoekRepository;
    GedetineerdeRepository gedetineerdeRepository;
    BezoekerRepository bezoekerRepository;

    public BezoekController(BezoekRepository bezoekRepository, GedetineerdeRepository gedetineerdeRepository, BezoekerRepository bezoekerRepository) {
        this.bezoekRepository = bezoekRepository;
        this.gedetineerdeRepository = gedetineerdeRepository;
        this.bezoekerRepository = bezoekerRepository;
    }

    @GetMapping("/filter/{datum}")
    public List<Bezoek> getAllBezoekOfToday(@PathVariable String datum) {
        LocalDate date = LocalDate.parse(datum);
        return bezoekRepository.findByDatumOrderByTijdAsc(date);
    }

    @GetMapping("/all")
    public List<Bezoek> getAllBezoek() {
        return bezoekRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Bezoek> getBezoekById(@PathVariable String id) {
        long idLong = Long.parseLong(id);
        return bezoekRepository.findById(idLong);
    }

    @PostMapping("/{gedetineerdeId}/{bezoekerId}")
    public Bezoek createBezoek(@RequestBody Bezoek bezoek, @PathVariable String gedetineerdeId, @PathVariable String bezoekerId) {
        long gedetineerdeIdLong = Long.parseLong(gedetineerdeId);
        long bezoekerIdLong = Long.parseLong(bezoekerId);
        Optional<Gedetineerde> gedetineerde = gedetineerdeRepository.findByRegistratieNummer(gedetineerdeIdLong);
        Optional<Bezoeker> bezoeker = bezoekerRepository.findById(bezoekerIdLong);

        if (gedetineerde.isPresent() && bezoeker.isPresent()) {
            bezoek.setGedetineerde(gedetineerde.get());
            bezoek.setBezoeker(bezoeker.get());
        }

        return bezoekRepository.save(bezoek);
    }

    @PatchMapping("/{id}")
    public void updateBezoek(@RequestBody Bezoek bezoek, @PathVariable String id) {
        long idLong = Long.parseLong(id);
        String status = bezoek.getStatus();
        Optional<Bezoek> bezoekOptional = bezoekRepository.findById(idLong);
        if (bezoekOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        bezoekOptional.get().setStatus(status);
        bezoekRepository.save(bezoek);
    }

    @DeleteMapping("/{id}")
    public void deleteBezoekById(@PathVariable long id) {
        bezoekRepository.deleteById(id);
    }

}
