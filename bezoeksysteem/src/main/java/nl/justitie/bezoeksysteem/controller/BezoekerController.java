package nl.justitie.bezoeksysteem.controller;

import nl.justitie.bezoeksysteem.model.Bezoeker;
import nl.justitie.bezoeksysteem.repository.BezoekerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bezoeker")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE} )
public class BezoekerController {
    BezoekerRepository bezoekerRepository;

    public BezoekerController(BezoekerRepository bezoekerRepository) {
        this.bezoekerRepository = bezoekerRepository;
    }

    @GetMapping("/{achterNaam}")
    public List<Bezoeker> getBezoekerByAchterNaam(@PathVariable String achterNaam) {
        return bezoekerRepository.findByAchterNaam(achterNaam);
    }

    @GetMapping("/{id}")
    public Optional<Bezoeker> getBezoekerById(@PathVariable long id) {
        return bezoekerRepository.findById(id);
    }

    @PostMapping
    public Bezoeker createBezoeker(@RequestBody Bezoeker bezoeker) {
        return bezoekerRepository.save(bezoeker);
    }

    @PatchMapping("/{id}")
    public void updateBezoeker(@RequestBody Bezoeker bezoeker) {
        long id = bezoeker.getId();
        long bsn = bezoeker.getBsn();
        Optional<Bezoeker> bezoekerOptional = bezoekerRepository.findById(id);
        if (bezoekerOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        bezoekerOptional.get().setBsn(bsn);
        bezoekerRepository.save(bezoekerOptional.get());
    }
}
