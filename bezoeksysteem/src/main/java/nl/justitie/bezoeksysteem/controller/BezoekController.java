package nl.justitie.bezoeksysteem.controller;

import nl.justitie.bezoeksysteem.model.Bezoek;
import nl.justitie.bezoeksysteem.model.Bezoeker;
import nl.justitie.bezoeksysteem.repository.BezoekRepository;
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

    public BezoekController(BezoekRepository bezoekRepository) {
        this.bezoekRepository = bezoekRepository;
    }

    @GetMapping
    public List<Bezoek> getAllBezoek() {
        return bezoekRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Bezoek> getBezoekById(@PathVariable long id) {
        return bezoekRepository.findById(id);
    }

    @PostMapping
    public Bezoek createBezoek(@RequestBody Bezoek bezoek) {
        return bezoekRepository.save(bezoek);
    }

    @PatchMapping
    public void updateBezoek(@RequestBody Bezoek bezoek) {
        long id = bezoek.getId();
        LocalDate datum = bezoek.getDatum();
        Optional<Bezoek> bezoekOptional = bezoekRepository.findById(id);
        if (bezoekOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        bezoekOptional.get().setDatum(datum);
        bezoekRepository.save(bezoek);
    }

    @DeleteMapping("/{id}")
    public void deleteBezoekById(@PathVariable long id) {
        bezoekRepository.deleteById(id);
    }

}
