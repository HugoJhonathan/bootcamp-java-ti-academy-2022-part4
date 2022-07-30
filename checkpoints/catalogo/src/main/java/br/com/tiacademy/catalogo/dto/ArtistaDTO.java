package br.com.tiacademy.catalogo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArtistaDTO implements Serializable {

    private Long id;

    private String nome;

}
