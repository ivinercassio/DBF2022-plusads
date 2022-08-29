package br.com.ivinerejose.plusAds.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ivinerejose.plusAds.model.User;
import br.com.ivinerejose.plusAds.model.repository.UserRepository;

@Service
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepositorio;

    public User save(User user) {
        user = userRepositorio.save(user);
        return user;
    }

    public Optional<User> findOne(Long id) {
        log.info("Request to get User : {}", id);
        return userRepositorio.findById(id);
    }

    public List<User> findAllList() {
        log.info("Request to get All Users");
        List<User> userList = userRepositorio.findAll();
        log.info("Return of getAllList " + userList.size());
        return userList;
    }

    public void delete(Long id) {
        log.info("Request to delete User : {}", id);
        userRepositorio.deleteById(id);
    }

    // public List<User> saveAll(List<User> userList) {
    //     log.info("Request to save User : {}", userList);
    //     userList = userRepositorio.saveAll(userList);
    //     return userList;
    // }
}
