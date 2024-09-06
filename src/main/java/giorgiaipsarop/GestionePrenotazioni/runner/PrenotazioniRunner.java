package giorgiaipsarop.GestionePrenotazioni.runner;

import com.github.javafaker.Faker;
import giorgiaipsarop.GestionePrenotazioni.RepoAndService.UserService;
import giorgiaipsarop.GestionePrenotazioni.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class PrenotazioniRunner implements CommandLineRunner {
    @Autowired
    UserService userService;


    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(Locale.US);

        User user = new User(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());

        userService.save(user);
        System.out.println(user);
    }
}
