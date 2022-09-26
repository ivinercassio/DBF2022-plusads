package br.com.ivinerejose.plusAds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import br.com.ivinerejose.plusAds.model.Contratante;
import br.com.ivinerejose.plusAds.model.repository.ContratanteRepository;


@SpringBootApplication
public class PlusAdsApplication implements ApplicationRunner{

	@Autowired
	ContratanteRepository contratanteRepository;

	public static void main(String[] args) {
		SpringApplication.run(PlusAdsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args){
		Contratante contratante = new Contratante("SubWay", null, "12345678910123", "subway@contratante.com", "123",
										"A", "31994375684", "31997455684");
		contratante = contratanteRepository.save(contratante); // retorna o mesmo contratante, mas agr com o id
		System.out.println(contratante);		
	}

}
