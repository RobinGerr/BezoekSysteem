package nl.justitie.bezoeksysteem.repository;

import nl.justitie.bezoeksysteem.model.Bezoek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BezoekRepository extends JpaRepository<Bezoek, Long> {
    Bezoek findByDatum(Date datum);
}
