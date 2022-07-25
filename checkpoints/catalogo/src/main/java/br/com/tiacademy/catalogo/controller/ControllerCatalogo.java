package br.com.tiacademy.catalogo.controller;

import br.com.tiacademy.catalogo.repository.RepositoryCatalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public abstract class ControllerCatalogo<T, ID> {

    @Autowired
    protected RepositoryCatalogo<T, ID> repository;

    @GetMapping
    public List<T> listar(){
        return repository.findAll();
    }

}
