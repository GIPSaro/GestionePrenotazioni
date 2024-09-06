package giorgiaipsarop.GestionePrenotazioni.RepoAndService;


import giorgiaipsarop.GestionePrenotazioni.entities.Building;
import giorgiaipsarop.GestionePrenotazioni.exception.ItemNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BuildingService {
    @Autowired
    private BuildingRepository buildingDao;

    public void save(Building building) {
        if (buildingDao.existsByName(building.getName())) {
            throw new RuntimeException("Nome già assegnato!");
        } else {
            buildingDao.save(building);
            log.info("Edificio salvato correttamente!");
        }
    }
    @Transactional
    public Building findById(UUID buildingId) {
        return buildingDao.findById(buildingId)
                .orElseThrow(() -> new ItemNotFoundException(buildingId));
    }

    @Transactional
    public void findByIdAndDelete(UUID buildingId) {
        Building found = findById(buildingId);  // Usa il metodo findById
        buildingDao.delete(found);
        log.info("Edificio con id " + buildingId + " cancellato correttamente!");
    }
}
