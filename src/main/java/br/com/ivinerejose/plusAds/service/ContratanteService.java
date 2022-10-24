package br.com.ivinerejose.plusAds.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ivinerejose.plusAds.model.Contratante;
import br.com.ivinerejose.plusAds.model.repository.ContratanteRepository;

@Service
public class ContratanteService {
    private final Logger log = LoggerFactory.getLogger(ContratanteService.class);

    @Autowired
    ContratanteRepository contratanteRepositorio;

    public Contratante save(Contratante contratante) {
        contratante = contratanteRepositorio.save(contratante);
        return contratante;
    }

    public Optional<Contratante> findOne(Long id) {
        log.info("Request to get Contratante : {}", id);
        return contratanteRepositorio.findById(id);
    }

    public List<Contratante> findAllList() {
        log.info("Request to get All Contratantes");
        List<Contratante> contratanteList = contratanteRepositorio.findAll();
        log.info("Return of getAllList " + contratanteList.size());
        return contratanteList;
    }

    public void delete(Long id) {
        log.info("Request to delete Contratante : {}", id);
        contratanteRepositorio.deleteById(id);
    }
}
