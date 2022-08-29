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

import br.com.ivinerejose.plusAds.model.User;
import br.com.ivinerejose.plusAds.service.UserService;

@Controller
@RequestMapping("api/plusads/user")
public class UserController {

    private static UserService userService;

    public UserController(UserService userService){
        UserController.userService = userService;
    }

    // retorna um user 
    @GetMapping("/{id}") 
    public ResponseEntity<User> getUser(@PathVariable Long id){
        Optional<User> userOp = userService.findOne(id);
        if(userOp.isPresent()){
            return ResponseEntity.ok().body(userOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    // retorna todos os users
    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers(){
        List<User> userList = userService.findAllList();
        if(userList.size() > 0){
            return ResponseEntity.ok().body(userList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    // altera um user
    @PutMapping("/")
    public ResponseEntity<User> update(@RequestBody User user){
        if(user == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid user id = null");
        }
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }

    // criar um user
    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User user){
        if(user.getId() != 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New User can't exist id");
        }
        User result = userService.save(user);
        return ResponseEntity.ok().body(user);
    }

    // deletar um user 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
