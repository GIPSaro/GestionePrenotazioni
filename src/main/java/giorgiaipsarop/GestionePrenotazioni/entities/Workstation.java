package giorgiaipsarop.GestionePrenotazioni.entities;


import giorgiaipsarop.GestionePrenotazioni.enums.WorkstationType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "workstations")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Workstation {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Setter(AccessLevel.NONE)
private UUID id;
private String description;
@Enumerated(EnumType.STRING)
    private WorkstationType workstationType;
@Column(name = "max_user")
    private int maxUser;


@ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
@OneToMany(mappedBy = "workstation")
    @ToString.Exclude
    private List<Reservation> reservationList;

public Workstation(String description, WorkstationType workstationType, int maxUser, Building building){
    this.description=description;
    this.workstationType=workstationType;
    this.maxUser=maxUser;
    this.building=building;
}
}
