package br.com.ivinerejose.plusAds.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import br.com.ivinerejose.plusAds.model.Anuncio;
import br.com.ivinerejose.plusAds.service.AnuncioService;

@Controller
@RequestMapping("api/plusads/anuncio")
public class AnuncioController {

    private static AnuncioService anuncioService;

    public AnuncioController(AnuncioService anuncioService){
        AnuncioController.anuncioService = anuncioService;
    }

    // retorna um anuncio 
    @GetMapping("/{id}") 
    public ResponseEntity<Anuncio> getAnuncio(@PathVariable Long id){
        Optional<Anuncio> anuncioOp = anuncioService.findOne(id);
        if(anuncioOp.isPresent()){
            return ResponseEntity.ok().body(anuncioOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    // retorna todos os anuncios
    @GetMapping("/")
    public ResponseEntity<List<Anuncio>> getAnuncios(){
        List<Anuncio> anuncioList = anuncioService.findAllList();
        if(anuncioList.size() > 0){
            return ResponseEntity.ok().body(anuncioList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    // altera um anuncio
    @PutMapping("/")
    public ResponseEntity<Anuncio> update(@RequestBody Anuncio anuncio){
        if(anuncio == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid anuncio id = null");
        }
        anuncioService.save(anuncio);
        return ResponseEntity.ok().body(anuncio);
    }

    // criar um anuncio
    @PostMapping("/")
    public ResponseEntity<Anuncio> create(@RequestBody Anuncio anuncio){
        if(anuncio.getId() != 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Anuncio can't exist id");
        }
        Anuncio result = anuncioService.save(anuncio);
        return ResponseEntity.ok().body(anuncio);
    }

    // deletar um anuncio 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnuncio(@PathVariable Long id){
        anuncioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
