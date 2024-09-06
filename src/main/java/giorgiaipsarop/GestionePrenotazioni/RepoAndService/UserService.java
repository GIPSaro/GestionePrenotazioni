package giorgiaipsarop.GestionePrenotazioni.RepoAndService;

import giorgiaipsarop.GestionePrenotazioni.entities.User;
import giorgiaipsarop.GestionePrenotazioni.exception.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UserService {
    @Autowired UserRepository userRepository;

    public void save(User user){
        if(userRepository.existsByName(user.getName())){
            throw new RuntimeException("Nome già assegnato!");
        }else{
            userRepository.save(user);
            log.info("Utente salvato con successo");
        }
    }
    public User findById(UUID userId){
        return userRepository.findById(userId).orElseThrow(()->new ItemNotFoundException(userId));
    }

    public void findByIdAndDelete(UUID userId){
        User found = this.findById(userId);
        userRepository.delete(found);
        log.info("Utente con id " + userId + " cancellato correttamente!");
    }
}
