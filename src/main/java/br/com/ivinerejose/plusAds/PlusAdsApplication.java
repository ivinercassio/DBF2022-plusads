package br.com.ivinerejose.plusAds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import br.com.ivinerejose.plusAds.model.User;
import br.com.ivinerejose.plusAds.model.repository.UserRepository;


@SpringBootApplication
public class PlusAdsApplication implements ApplicationRunner{

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(PlusAdsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args){
		User user = new User("cnpj", "email@teste.com", "123");
		user = userRepository.save(user); // retorna o mesmo pet, mas agr com o id
		System.out.println(user);		
	}

}
