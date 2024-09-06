package giorgiaipsarop.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "buildings")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Setter
    private UUID id;
    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "building")
    @ToString.Exclude
    private List<Workstation> workstationList;

    public Building(String name, String address, String city){
        this.name=name;
        this.address=address;
        this.city=city;
    }
}
