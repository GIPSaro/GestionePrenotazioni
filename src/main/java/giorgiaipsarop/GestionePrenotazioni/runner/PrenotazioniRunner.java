package giorgiaipsarop.GestionePrenotazioni.runner;

import com.github.javafaker.Faker;
import giorgiaipsarop.GestionePrenotazioni.RepoAndService.BuildingService;
import giorgiaipsarop.GestionePrenotazioni.RepoAndService.ReservationService;
import giorgiaipsarop.GestionePrenotazioni.RepoAndService.UserService;
import giorgiaipsarop.GestionePrenotazioni.RepoAndService.WorkstationService;
import giorgiaipsarop.GestionePrenotazioni.entities.Building;
import giorgiaipsarop.GestionePrenotazioni.entities.Reservation;
import giorgiaipsarop.GestionePrenotazioni.entities.User;
import giorgiaipsarop.GestionePrenotazioni.entities.Workstation;
import giorgiaipsarop.GestionePrenotazioni.enums.WorkstationType;
import giorgiaipsarop.GestionePrenotazioni.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

@Component
public class PrenotazioniRunner implements CommandLineRunner {
    @Autowired
    UserService userService;

    @Autowired
    BuildingService buildingService;

    @Autowired
    WorkstationService workstationService;

    @Autowired
    ReservationService reservationService;

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(Locale.US);

        User user1 = new User(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
        User user2 = new User(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
        User user3 = new User(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);


        Building building = new Building(faker.company().name(), faker.address().fullAddress(), faker.address().city());
        buildingService.save(building);

        Workstation workstation1 = new Workstation(faker.lorem().sentence(5), WorkstationType.SALA_RIUNIONI, 1, building);
        Workstation workstation2 = new Workstation(faker.lorem().sentence(5), WorkstationType.PRIVATO, 2, building);
        Workstation workstation3 = new Workstation(faker.lorem().sentence(5), WorkstationType.OPENSPACE, 5, building);
//
        workstationService.save(workstation1);
        workstationService.save(workstation2);
        workstationService.save(workstation3);


        Reservation reservation = new Reservation(LocalDate.now(), user1, workstation1);
        reservationService.save(reservation);


//  Provo a testare se è possibile fare un'altra prenotazione con capienza piena o stesso giorno dallo stesso utente ***

//        Reservation reservationTest = new Reservation(LocalDate.now(), user1, workstation2);
//        Reservation reservationTest2 = new Reservation(LocalDate.now(), user1, workstation2);
//
//        reservationService.save(reservationTest);
//        reservationService.save(reservationTest2);


//        try {
//            UUID id = UUID.fromString("7522c9fc-939b-4096-b15b-4a3d446375a6");
//            userService.findByIdAndDelete(id);
//        } catch (ItemNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }

//        try {
//            UUID id = UUID.fromString("1eab0f56-d71c-451b-8041-566151d45dad");
//            buildingService.findByIdAndDelete(id);
//        } catch (ItemNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//

        // Da questa prova ho trovato sul web informazioni sull'annotazione @Transactional

//        try {
//            UUID id = UUID.fromString("931942b7-029d-448f-852a-9815e2fc86bf");
//            workstationService.findByIdAndDelete(id);
//        } catch (ItemNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }


//        try {
//            UUID id = UUID.fromString("e2cf1ab4-5bf6-47bf-9e09-8fbb0b2478e2");
//            reservationService.findByIdAndDelete(id);
//        } catch (ItemNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }


        System.out.println("TEST RICERCA POSTAZIONE");
        workstationService
                .findByTypeAndCity(WorkstationType.SALA_RIUNIONI, "Aleasefurt")
                .forEach(System.out::println);
   }

    }
