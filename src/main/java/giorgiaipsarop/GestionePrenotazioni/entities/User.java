package giorgiaipsarop.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.SimpleTimeZone;
import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String username;
    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Reservation> reservationList;

    public User(String username, String name, String email){
        this.username= username;
        this.name= name;
        this.email=email;
    }
}
