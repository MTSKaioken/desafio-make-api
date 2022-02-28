package api.com.nextsoft.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import api.com.nextsoft.exceptions.EnderecoNotFoundException;
import api.com.nextsoft.models.Endereco;
import api.com.nextsoft.repositories.EnderecosRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    
    private final EnderecosRepository enderecosRepository;

    public EnderecoController(EnderecosRepository enderecosRepository) {
        this.enderecosRepository = enderecosRepository;
    }

    @GetMapping
    public List<Endereco> findAllEndereco() {  
        return enderecosRepository.findAll();
    }

    @GetMapping("/{id}")
    public Endereco findOneEndereco(@PathVariable Long id) { 
    return enderecosRepository.findById(id).orElseThrow(() -> new EnderecoNotFoundException(id));
    }
    
    @PutMapping
    public void updateAllFieldsInvoid(){
    }

    @PatchMapping("/{id}")
    public void updatePartialsFieldsInEndereco(){
    }

    @DeleteMapping("/{id}") //delete check
    public void deleteEndereco(@PathVariable Long id){
        enderecosRepository.deleteById(id);
    }
}
