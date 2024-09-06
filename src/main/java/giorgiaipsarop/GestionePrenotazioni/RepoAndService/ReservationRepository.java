package giorgiaipsarop.GestionePrenotazioni.RepoAndService;


import giorgiaipsarop.GestionePrenotazioni.entities.Reservation;
import giorgiaipsarop.GestionePrenotazioni.entities.User;
import giorgiaipsarop.GestionePrenotazioni.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    @Query("SELECT r FROM Reservation r WHERE r.user = :user AND r.date = :date")
    List<Reservation> filterBySameUserAndDate(User user, LocalDate date);

    @Query("SELECT COUNT(r) FROM Reservation r WHERE r.workstation = :workstation AND r.date = :date")
    int fullSlot(Workstation workstation, LocalDate date);

}
