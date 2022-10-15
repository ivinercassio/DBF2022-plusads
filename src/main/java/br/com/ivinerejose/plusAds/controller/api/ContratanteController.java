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
import org.springframework.web.servlet.ModelAndView;

import br.com.ivinerejose.plusAds.model.Contratante;
import br.com.ivinerejose.plusAds.service.ContratanteService;

@Controller
@RequestMapping("api/plusads/contratante")
public class ContratanteController {

    private static ContratanteService contratanteService;

    public ContratanteController(ContratanteService contratanteService){
        ContratanteController.contratanteService = contratanteService;
    }

    // retorna um contratante 
    @GetMapping("/{id}") 
    public ResponseEntity<Contratante> getContratante(@PathVariable Long id){
        Optional<Contratante> contratanteOp = contratanteService.findOne(id);
        if(contratanteOp.isPresent()){
            return ResponseEntity.ok().body(contratanteOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    // retorna todos os contratantes
    @GetMapping("/")
    public ResponseEntity<List<Contratante>> getContratantes(){
        List<Contratante> contratanteList = contratanteService.findAllList();
        if(contratanteList.size() > 0){
            return ResponseEntity.ok().body(contratanteList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    // altera um contratante
    @PutMapping("/")
    public ResponseEntity<Contratante> update(@RequestBody Contratante contratante){
        if(contratante == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid contratante id = null");
        }
        contratanteService.save(contratante);
        return ResponseEntity.ok().body(contratante);
    }

    // criar um contratante
    @PostMapping("/")
    public ResponseEntity<Contratante> create(@RequestBody Contratante contratante){
        if(contratante.getId() != 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Contratante can't exist id");
        }
        Contratante result = contratanteService.save(contratante);
        return ResponseEntity.ok().body(contratante);
    }

    // deletar um contratante 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContratante(@PathVariable Long id){
        contratanteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // retorna contratante com email e senha informados
    // @PostMapping("/login/{email}/{senha}")
    // public ModelAndView login(@PathVariable String email, @PathVariable String senha){
    //     if(email == null || senha == null){
    //         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contratante can't to be login");
    //     }
    //     ModelAndView result = contratanteService.loginContratante(email, senha);
    //     return ResponseEntity.ok().body(result.get());
    // }

    /* 
     * public ResponseEntity<Contratante> create(@RequestBody Contratante contratante){
        if(contratante.getId() != 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Contratante can't exist id");
        }
        Contratante result = contratanteService.save(contratante);
        return ResponseEntity.ok().body(contratante);
    }
     */
}
