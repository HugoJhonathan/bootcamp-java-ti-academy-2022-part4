package br.com.tiacademy.vendas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// @Table(name = "vendedor") // Se a Classe não tiver o mesmo nome da Tabela do BD, precisa definir com essa annotation
public class Vendedor {

    @Id // PrimaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO: IDENTITY:
    private Long id;

    private String nome;

    public Vendedor(){}

    public Vendedor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
