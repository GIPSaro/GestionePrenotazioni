package giorgiaipsarop.GestionePrenotazioni.RepoAndService;


import giorgiaipsarop.GestionePrenotazioni.entities.Building;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
