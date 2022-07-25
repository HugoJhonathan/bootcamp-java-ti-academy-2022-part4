package br.com.tiacademy.catalogo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artista extends EntidadeCatalogo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


    public Artista() {
    }

    public Artista(Long id, String nome) {
        setId(id);
        setNome(nome);
    }

}