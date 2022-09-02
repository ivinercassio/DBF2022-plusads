package br.com.ivinerejose.plusAds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import br.com.ivinerejose.plusAds.model.Anuncio;
import br.com.ivinerejose.plusAds.model.repository.AnuncioRepository;


@SpringBootApplication
public class PlusAdsApplication implements ApplicationRunner{

	@Autowired
	AnuncioRepository anuncioRepository;

	public static void main(String[] args) {
		SpringApplication.run(PlusAdsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args){
		Anuncio anuncio = new Anuncio("SubWay", "imagem", 2.50, "01/09/2022", "A");
		anuncio = anuncioRepository.save(anuncio); // retorna o mesmo anuncio, mas agr com o id
		System.out.println(anuncio);		
	}

}
