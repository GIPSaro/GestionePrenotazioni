package giorgiaipsarop.GestionePrenotazioni.entities;


import giorgiaipsarop.GestionePrenotazioni.enums.WorkstationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "workstations")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Workstation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id", nullable = false)
private Long id;
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
    private List<Reservation> workstationList;

public Workstation(String description, WorkstationType workstationType, int maxUser, Building building){
    this.description=description;
    this.workstationType=workstationType;
    this.maxUser=maxUser;
    this.building=building;
}
}
