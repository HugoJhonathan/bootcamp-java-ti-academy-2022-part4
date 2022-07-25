package br.com.tiacademy.catalogo.controller;

import br.com.tiacademy.catalogo.entity.Artista;
import br.com.tiacademy.catalogo.repository.ArtistaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/artista")
public class ArtistaController extends ControllerCatalogo<Artista, Long>{

    public ArtistaRepository getRepository(){
        return (ArtistaRepository) this.repository;
    }

    @GetMapping("/gil")
    public Artista artistaPorNome(){
        return this.getRepository().consultarPeloNome("Gilberto Gil");
    }

    @GetMapping("/djavan")
    public Artista artistaPorNome2(){
        return this.getRepository().consultarPeloNome("Djavan");
    }

}



