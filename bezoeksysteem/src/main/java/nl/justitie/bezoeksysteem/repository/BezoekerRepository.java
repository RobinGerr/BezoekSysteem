package nl.justitie.bezoeksysteem.repository;

import nl.justitie.bezoeksysteem.model.Bezoeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BezoekerRepository extends JpaRepository<Bezoeker,Long> {
   List<Bezoeker> findByAchterNaam(String achterNaam);
   Optional<Bezoeker> findById(Long id);
   @Query("SELECT b FROM Bezoeker b WHERE b.achterNaam = :achterNaam ORDER BY b.id DESC")
   Optional<Bezoeker> findLastByAchterNaam(@Param("achterNaam") String achterNaam);
   @Query("SELECT b FROM Bezoeker b ORDER BY b.id DESC")
   Optional<Bezoeker> findLastBezoeker();
   List<Bezoeker> findAllByAchterNaam(String achterNaam);
}
