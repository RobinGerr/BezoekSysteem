package nl.justitie.bezoeksysteem.repository;

import nl.justitie.bezoeksysteem.model.Gedetineerde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GedetineerdeRepository extends JpaRepository<Gedetineerde, Long> {
    List<Gedetineerde> findByAchterNaam(String achterNaam);
    Optional<Gedetineerde> findByRegistratieNummer(long registratieNummer);
    List<Gedetineerde> findAllByAfdeling(String afdeling);

    String afdeling(String afdeling);
}
