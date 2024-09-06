package giorgiaipsarop.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
