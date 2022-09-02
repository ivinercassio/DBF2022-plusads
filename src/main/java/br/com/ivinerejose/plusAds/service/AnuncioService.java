package br.com.ivinerejose.plusAds.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ivinerejose.plusAds.model.Anuncio;
import br.com.ivinerejose.plusAds.model.repository.AnuncioRepository;

@Service
public class AnuncioService {
    private final Logger log = LoggerFactory.getLogger(AnuncioService.class);

    @Autowired
    AnuncioRepository anuncioRepositorio;

    public Anuncio save(Anuncio anuncio) {
        anuncio = anuncioRepositorio.save(anuncio);
        return anuncio;
    }

    public Optional<Anuncio> findOne(Long id) {
        log.info("Request to get Anuncio : {}", id);
        return anuncioRepositorio.findById(id);
    }

    public List<Anuncio> findAllList() {
        log.info("Request to get All Anuncios");
        List<Anuncio> anuncioList = anuncioRepositorio.findAll();
        log.info("Return of getAllList " + anuncioList.size());
        return anuncioList;
    }

    public void delete(Long id) {
        log.info("Request to delete Anuncio : {}", id);
        anuncioRepositorio.deleteById(id);
    }

    // public List<Anuncio> saveAll(List<Anuncio> anuncioList) {
    //     log.info("Request to save Anuncio : {}", anuncioList);
    //     anuncioList = anuncioRepositorio.saveAll(anuncioList);
    //     return anuncioList;
    // }
}
