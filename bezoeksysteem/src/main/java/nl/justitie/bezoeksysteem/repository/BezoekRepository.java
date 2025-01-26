package nl.justitie.bezoeksysteem.repository;

import nl.justitie.bezoeksysteem.model.Bezoek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BezoekRepository extends JpaRepository<Bezoek, Long> {
    List<Bezoek> findByDatumOrderByTijdAsc(LocalDate datum);
}
