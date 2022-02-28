package api.com.nextsoft.repositories;

import org.springframework.stereotype.Repository;

import api.com.nextsoft.models.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EnderecosRepository extends JpaRepository<Endereco, Long>{
    
}
