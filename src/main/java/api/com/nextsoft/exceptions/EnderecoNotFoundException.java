package api.com.nextsoft.exceptions;

public class EnderecoNotFoundException extends RuntimeException {
      
    public EnderecoNotFoundException(Long id) {
        super("Endereco de ID "+id+" Não encontrado!");
    }
}
