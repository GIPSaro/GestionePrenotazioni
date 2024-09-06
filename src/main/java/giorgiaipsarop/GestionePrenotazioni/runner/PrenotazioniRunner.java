package giorgiaipsarop.GestionePrenotazioni.runner;

import com.github.javafaker.Faker;
import giorgiaipsarop.GestionePrenotazioni.RepoAndService.BuildingService;
import giorgiaipsarop.GestionePrenotazioni.RepoAndService.UserService;
import giorgiaipsarop.GestionePrenotazioni.entities.Building;
import giorgiaipsarop.GestionePrenotazioni.entities.User;
import giorgiaipsarop.GestionePrenotazioni.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.UUID;

@Component
public class PrenotazioniRunner implements CommandLineRunner {
    @Autowired
    UserService userService;

    @Autowired
    BuildingService buildingService;

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(Locale.US);

        User user = new User(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
        Building building = new Building(faker.company().name(), faker.address().fullAddress(), faker.address().city());

//
//        userService.save(user);
//        System.out.println(user);


        buildingService.save(building);
//        try {
//            UUID id = UUID.fromString("7522c9fc-939b-4096-b15b-4a3d446375a6");
//            userService.findByIdAndDelete(id);
//        } catch (ItemNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
   }
}
