package br.com.ivinerejose.plusAds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import br.com.ivinerejose.plusAds.model.Anunciante;
import br.com.ivinerejose.plusAds.model.Contratante;
import br.com.ivinerejose.plusAds.model.repository.AnuncianteRepository;
import br.com.ivinerejose.plusAds.model.repository.ContratanteRepository;


@SpringBootApplication
public class PlusAdsApplication implements ApplicationRunner{

	@Autowired
	ContratanteRepository contratanteRepository;
	@Autowired
	AnuncianteRepository anuncianteRepository;

	public static void main(String[] args) {
		SpringApplication.run(PlusAdsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args){
		Contratante contratante = new Contratante("SubWay", null, "12345678910123", 
												"subway@contratante.com", "123", 
												"A", "31994375684", "31997455684");
		contratante = contratanteRepository.save(contratante); // retorna o mesmo contratante, mas agr com o id
		System.out.println("Contratante: " + contratante);	

		Anunciante anunciante = new Anunciante("Antonio Fagundes", "14472362607", null, "antonioFagundes@gmail.com", "123",
										"A", "31980210630", "31932837581");
		anunciante = anuncianteRepository.save(anunciante); // retorna o mesmo anunciante, mas agr com o id
		System.out.println(anunciante);	
	}

}
