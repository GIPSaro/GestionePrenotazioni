package giorgiaipsarop.GestionePrenotazioni.RepoAndService;


import giorgiaipsarop.GestionePrenotazioni.entities.Reservation;
import giorgiaipsarop.GestionePrenotazioni.entities.Workstation;
import giorgiaipsarop.GestionePrenotazioni.enums.WorkstationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class WorkstationService {
@Autowired
  private  WorkstationRepository workstationRepository;

    public void save(Workstation workstation) {
        workstationRepository.save(workstation);
        log.info("Postazione salvata correttamente!");
    }

    public List<Workstation> findByTypeAndCity(WorkstationType workstationType, String city) {
        return workstationRepository.findByTypeAndCity(workstationType, city);
    }


}
