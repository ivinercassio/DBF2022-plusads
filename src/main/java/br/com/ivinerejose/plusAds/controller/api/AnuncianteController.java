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

import br.com.ivinerejose.plusAds.model.Anunciante;
import br.com.ivinerejose.plusAds.service.AnuncianteService;

@Controller
@RequestMapping("api/plusads/anunciante")
public class AnuncianteController {

    private static AnuncianteService anuncianteService;

    public AnuncianteController(AnuncianteService anuncianteService){
        AnuncianteController.anuncianteService = anuncianteService;
    }

    @GetMapping("/{id}") 
    public ResponseEntity<Anunciante> getAnunciante(@PathVariable Long id){
        Optional<Anunciante> anuncianteOp = anuncianteService.findOne(id);
        if(anuncianteOp.isPresent()){
            return ResponseEntity.ok().body(anuncianteOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Anunciante>> getAnunciantes(){
        List<Anunciante> anuncianteList = anuncianteService.findAllList();
        if(anuncianteList.size() > 0){
            return ResponseEntity.ok().body(anuncianteList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Anunciante> update(@RequestBody Anunciante anunciante){
        if(anunciante == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid anunciante id = null");
        }
        anuncianteService.save(anunciante);
        return ResponseEntity.ok().body(anunciante);
    }

    @PostMapping("/")
    public ResponseEntity<Anunciante> create(@RequestBody Anunciante anunciante){
        if(anunciante.getId() != 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Anunciante can't exist id");
        }
        Anunciante result = anuncianteService.save(anunciante);
        return ResponseEntity.ok().body(anunciante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnunciante(@PathVariable Long id){
        anuncianteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
