package nl.justitie.bezoeksysteem.repository;

import nl.justitie.bezoeksysteem.model.Bezoeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BezoekerRepository extends JpaRepository<Bezoeker,Long> {
   List<Bezoeker> findByAchterNaam(String achterNaam);
   Optional<Bezoeker> findById(Long id);
}
