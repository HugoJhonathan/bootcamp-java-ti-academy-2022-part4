package br.com.tiacademy.catalogo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gravadora extends EntidadeCatalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer ano;

    private String cidade;

    private String uf;

    @OneToMany(mappedBy = "gravadora")
    private List<Artista> artista = new ArrayList<>();


}
