package giorgiaipsarop.GestionePrenotazioni.RepoAndService;


import giorgiaipsarop.GestionePrenotazioni.entities.Reservation;
import giorgiaipsarop.GestionePrenotazioni.exception.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;


    public void save(Reservation reservation) {
        int maxSlotOfWorkstation = reservation.getWorkstation().getMaxUser();
        int actualFullSlotOfWorkstation = reservationRepository.fullSlot(reservation.getWorkstation(), reservation.getDate());
        List<Reservation> reservations = reservationRepository.filterBySameUserAndDate(reservation.getUser(), reservation.getDate());

        if (reservations.isEmpty() && maxSlotOfWorkstation > actualFullSlotOfWorkstation) {
            reservationRepository.save(reservation);
            log.info("Prenotazione salvata correttamente!");
        } else {
            throw new RuntimeException("L'utente ha già una prenotazione per questa data oppure la postazione è piena!");
        }

    }
    public Reservation findById(UUID reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ItemNotFoundException(reservationId));
    }

    public void findByIdAndDelete(UUID reservationId) {
        Reservation found = this.findById(reservationId);
        reservationRepository.delete(found);
        log.info("Prenotazione con id " + reservationId + " cancellata correttamente!");
    }
}

