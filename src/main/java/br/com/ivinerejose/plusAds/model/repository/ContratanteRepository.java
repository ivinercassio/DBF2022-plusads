package br.com.ivinerejose.plusAds.model.repository;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ivinerejose.plusAds.model.Contratante;

@Repository
public interface ContratanteRepository extends JpaRepository<Contratante, Long>{

    // @Query("select c from Contratante c where c.email = :email and c.senha = :senha")
    // public Optional<Contratante> buscarLogin(String email, String senha);
}