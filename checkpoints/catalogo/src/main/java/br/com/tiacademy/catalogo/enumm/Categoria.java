package br.com.tiacademy.catalogo.enumm;

import lombok.Data;


public enum Categoria {

    JAZZ("J"),
    ROCK("R"),
    CLASSICO("C");

    Categoria(String prefixo){
        this.prefixo = prefixo;
    }

    private String prefixo;

    public String getPrefixo() {
        return prefixo;
    }
}
