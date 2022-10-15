package br.com.ivinerejose.plusAds.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ivinerejose.plusAds.model.Anunciante;
import br.com.ivinerejose.plusAds.model.repository.AnuncianteRepository;

@Service
public class AnuncianteService {
    private final Logger log = LoggerFactory.getLogger(AnuncianteService.class);

    @Autowired
    AnuncianteRepository anuncianteRepositorio;

    public Anunciante save(Anunciante anunciante) {
        anunciante = anuncianteRepositorio.save(anunciante);
        return anunciante;
    }

    public Optional<Anunciante> findOne(Long id) {
        log.info("Request to get Anunciante : {}", id);
        return anuncianteRepositorio.findById(id);
    }

    public List<Anunciante> findAllList() {
        log.info("Request to get All Anunciantes");
        List<Anunciante> anuncianteList = anuncianteRepositorio.findAll();
        log.info("Return of getAllList " + anuncianteList.size());
        return anuncianteList;
    }

    public void delete(Long id) {
        log.info("Request to delete Anunciante : {}", id);
        anuncianteRepositorio.deleteById(id);
    }
}
