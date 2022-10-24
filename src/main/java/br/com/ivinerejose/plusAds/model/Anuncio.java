package br.com.ivinerejose.plusAds.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    @Column(length = 11)
    private String imagem;

    @Column(length = 60, nullable = false)
    private Double preco;

    @Column(length = 60, nullable = false)
    private String dtValidade;
    
    @Column(length = 60, nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "contratante", nullable = false, foreignKey = @ForeignKey(name = "fk_anucio_contratante"))
    private Contratante contratante;

    public Anuncio (String titulo, String imagem, Double preco, String dtValidade, 
                    String status, Contratante contratante){
        this.titulo = titulo;
        this.imagem = imagem;
        this.preco = preco;
        this.dtValidade = dtValidade;
        this.status = status;
        this.contratante = contratante;
    }
}
