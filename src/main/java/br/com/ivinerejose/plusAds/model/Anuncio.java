package br.com.ivinerejose.plusAds.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity (name="anuncio")

public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(length = 60, nullable = false)
    private String titulo;

    @Column(length = 60, nullable = true)
    private String imagem;

    @Column(length = 60, nullable = false)
    private Double preco;

    @Column(length = 60, nullable = false)
    private String dataValidade;
    
    @Column(length = 60, nullable = false)
    private String status;

    public Anuncio(String titulo, String imagem, Double preco, String dataValidade, String status){
        this.titulo = titulo;
        this.imagem = imagem;
        this.preco = preco;
        this.dataValidade = dataValidade;
        this.status = status;
    }
}

