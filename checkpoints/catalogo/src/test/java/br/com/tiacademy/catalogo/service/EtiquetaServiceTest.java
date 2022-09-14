package br.com.tiacademy.catalogo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.tiacademy.catalogo.enumm.Categoria;
import org.junit.jupiter.api.Test;

public class EtiquetaServiceTest {
    // teste sempre void
    @Test
    public void deveConterNoveDigitos(){

        var etiquetasSevice = new EtiquetaService();

        var resultado = etiquetasSevice.gerarEtiqueta(Categoria.JAZZ);
        assertEquals(9, resultado.length()); // a condição que passar aqui dentro tem que ser verdadeira

    }

    @Test
    public void deveSerAlphaNumerico(){

        var etiquetasSevice = new EtiquetaService();

        var resultado = etiquetasSevice.gerarEtiqueta(Categoria.ROCK);

        assertTrue(resultado.matches("^[A-Za-z0-9]+$"));

    }

    @Test
    public void primeiroCaracterDeveSerNumero(){

        var etiquetasSevice = new EtiquetaService();

        var resultado = etiquetasSevice.gerarEtiqueta(Categoria.CLASSICO);

        assertTrue(resultado.startsWith("C"));
//        assertEquals(resultado.startsWith("C"), true);
    }
}
