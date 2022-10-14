package br.com.ivinerejose.plusAds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import br.com.ivinerejose.plusAds.controller.api.ContratanteController;
import br.com.ivinerejose.plusAds.model.Contratante;
import br.com.ivinerejose.plusAds.model.repository.ContratanteRepository;


@SpringBootApplication
public class PlusAdsApplication implements ApplicationRunner{

	@Autowired
	ContratanteRepository contratanteRepository;
	@Autowired
	ContratanteController contratanteController;

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

		// editando o primeiro
		// System.out.println("Vamos editar isso...");
		// contratante.setEmail("email@contratante.com");
		// System.out.println("Editado: " + contratanteController.update(contratante));
		
		// Contratante contratante2 = new Contratante("Lenovo", "08912345715", null, 
		// 										"lenovo@contratante.com", "123",
		// 										"A", "31994578461", null);
		// contratante2 = contratanteRepository.save(contratante2); // retorna o mesmo contratante, mas agr com o id
		// System.out.println("Contratante: " + contratante2);	

		// excluindo o segundo 
		// System.out.println("Vamos excluir o segundo contratante...");
		// System.out.println("Excluido: " + contratanteController.deleteContratante(contratante2.getId()));
		// if(contratante2 != null){
		// 	System.out.println("Contratante 2: " + contratante2);
		// }else{
		// 	System.out.println("Registro excluido com sucesso!!");
		// }
	}

}
