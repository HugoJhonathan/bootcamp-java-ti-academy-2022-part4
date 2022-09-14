package br.com.tiacademy.catalogo.entity;

import java.io.Serializable;

public class EntidadeCatalogo implements Serializable {

    private static final long serialVersionUID = -1621840087149135537L;

    private Long id;
    private String nome;

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
