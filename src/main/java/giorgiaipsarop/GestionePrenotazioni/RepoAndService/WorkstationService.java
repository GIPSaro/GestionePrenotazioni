package giorgiaipsarop.GestionePrenotazioni.RepoAndService;


import giorgiaipsarop.GestionePrenotazioni.entities.Workstation;
import giorgiaipsarop.GestionePrenotazioni.enums.WorkstationType;
import giorgiaipsarop.GestionePrenotazioni.exception.ItemNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class WorkstationService {
@Autowired
  private  WorkstationRepository workstationRepository;
@Autowired
private ReservationRepository reservationRepository;
    public void save(Workstation workstation) {
        workstationRepository.save(workstation);
        log.info("Postazione salvata correttamente!");
    }

    @Transactional
    // ho fatto un po' di prove per elminare tramite id, ma essendo collegato con la "Reservation" non mi eliminava
    // l'elemento, quindi con della documentazione ho visto che questa annotazione si usa quando si eseguono
    // operazioni di database che devono essere completate tutte insieme o non eseguite affatto.
    public Workstation findById(UUID workstationId) {
        return workstationRepository.findById(workstationId)
                .orElseThrow(() -> new ItemNotFoundException(workstationId));
    }

    @Transactional
    public void findByIdAndDelete(UUID workstationId) {
        Workstation workstation = findById(workstationId);

        // Trova e cancella tutte le prenotazioni associate
        reservationRepository.deleteByWorkstationId(workstationId);

        workstationRepository.delete(workstation);
        log.info("Postazione con id " + workstationId + " cancellata correttamente!");

        workstationRepository.delete(workstation);
        log.info("Postazione con id " + workstationId + " cancellata correttamente!");

    }
    public List<Workstation> findByTypeAndCity(WorkstationType workstationType, String city) {
        return workstationRepository.findByTypeAndCity(workstationType, city);
    }

}
