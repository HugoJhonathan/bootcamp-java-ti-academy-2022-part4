package br.com.tiacademy.catalogo.service;

import br.com.tiacademy.catalogo.enumm.Categoria;

public class EtiquetaService {

    public String gerarEtiqueta(Categoria categoria){

        return String.format("%s23456789", categoria.getPrefixo());

    }
}
