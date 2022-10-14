package br.com.ivinerejose.plusAds.model;


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
@Entity (name="contratante")

public class Contratante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(length = 14, nullable = false)
    private String nome;

    @Column(length = 11)
    private String cpf;

    @Column(length = 60)
    private String cnpj;

    @Column(length = 60, nullable = false)
    private String email;
    
    @Column(length = 60, nullable = false)
    private String senha;

    @Column(length = 1, nullable = false)
    private String status;

    @Column(length = 13, nullable = false)
    private String telefone1;

    @Column(length = 13)
    private String telefone2;

    public Contratante (String nome, String cpf, String cnpj, String email, String senha, 
                    String status, String telefone1, String telefone2){
        this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.status = status;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
    }
}

