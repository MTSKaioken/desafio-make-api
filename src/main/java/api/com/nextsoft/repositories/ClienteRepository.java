package api.com.nextsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.com.nextsoft.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    
}
