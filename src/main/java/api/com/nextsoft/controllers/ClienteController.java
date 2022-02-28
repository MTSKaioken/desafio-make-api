package api.com.nextsoft.controllers;
import api.com.nextsoft.models.Cliente;
import api.com.nextsoft.repositories.ClienteRepository;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    //possivel erro no ID dos endereços
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping //Post check
    public Cliente newCliente(@RequestBody Cliente clienteModel) {
      return clienteRepository.save(clienteModel);
    }

    @GetMapping //getAll Check
    public List<Cliente> findAllClient() { 
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}") //getOne check
    public ResponseEntity findCliente(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PatchMapping("/{id}")
    public void updateCliente(@RequestBody Cliente clienteModel){
      //clienteRepository.deleteById(clienteModel.getId());
    }

    @DeleteMapping("/{id}") //delete check
    public ResponseEntity deleteCliente(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            clienteRepository.deleteById(id);
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
  
}
