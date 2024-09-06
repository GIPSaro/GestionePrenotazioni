package giorgiaipsarop.GestionePrenotazioni.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="reservations")
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="workstation_id")
    private Workstation workstation;

    public Reservation(LocalDate date, User user, Workstation workstation){
        this.date=date;
        this.user=user;
        this.workstation=workstation;
    }
}