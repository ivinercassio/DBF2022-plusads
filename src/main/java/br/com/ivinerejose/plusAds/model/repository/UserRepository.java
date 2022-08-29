package br.com.ivinerejose.plusAds.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ivinerejose.plusAds.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}