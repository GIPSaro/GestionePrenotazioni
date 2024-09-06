package giorgiaipsarop.GestionePrenotazioni.RepoAndService;

import giorgiaipsarop.GestionePrenotazioni.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BuildingRepository extends JpaRepository<Building, UUID> {
    boolean existsByName(String name);
}
