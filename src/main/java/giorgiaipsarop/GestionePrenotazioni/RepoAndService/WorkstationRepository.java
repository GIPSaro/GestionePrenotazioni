package giorgiaipsarop.GestionePrenotazioni.RepoAndService;


import giorgiaipsarop.GestionePrenotazioni.entities.Workstation;
import giorgiaipsarop.GestionePrenotazioni.enums.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, UUID> {

    @Query("SELECT w FROM Workstation w JOIN w.building b WHERE w.workstationType = :workstationType AND LOWER(b.city) = LOWER(:city)")
    List<Workstation> findByTypeAndCity(WorkstationType workstationType, String city);
}
