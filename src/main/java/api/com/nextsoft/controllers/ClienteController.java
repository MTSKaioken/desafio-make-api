package api.com.nextsoft.controllers;
import api.com.nextsoft.models.Cliente;
import api.com.nextsoft.repositories.ClienteRepository;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    //possivel erro no ID dos endereços
    private ClienteRepository clienteRepository;

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
    public ResponseEntity<Optional<Cliente>> findCliente(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity updatePartialsCliente(@PathVariable Long id, @RequestBody Cliente clienteModel){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            clienteRepository.save(clienteModel);
            return ResponseEntity.ok(cliente.get());
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAllFieldsCliente(@PathVariable Long id, @RequestBody Cliente clienteModel){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            clienteRepository.save(clienteModel);
            return ResponseEntity.ok(cliente.get());
        } else{
            return ResponseEntity.notFound().build();
        }
        
    }

    @DeleteMapping("/{id}") //delete check
    public ResponseEntity deleteCliente(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
  
}
