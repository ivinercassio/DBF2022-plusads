package br.com.ivinerejose.plusAds.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ivinerejose.plusAds.model.Contratante;

@Repository
public interface ContratanteRepository extends JpaRepository<Contratante, Long>{
}