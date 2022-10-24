package br.com.ivinerejose.plusAds.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ivinerejose.plusAds.model.Anuncio;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long>{
}
