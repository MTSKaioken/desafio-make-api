package api.com.nextsoft.exceptions;

public class ClienteNotFoundException extends RuntimeException {
      
    public ClienteNotFoundException(Long id) {
        super("Cliente de ID "+id+" Não encontrado!");
    }
}
