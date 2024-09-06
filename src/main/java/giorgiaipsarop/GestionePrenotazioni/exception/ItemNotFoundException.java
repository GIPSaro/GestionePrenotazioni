package giorgiaipsarop.GestionePrenotazioni.exception;

import java.util.UUID;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(UUID id){
        super("Il record con l'Id" + id + "non è stato trovato!");
    }
    public ItemNotFoundException(){
        super("Il record non è stato trovato!");
    }
}
