package br.com.tiacademy.catalogo.controller;

import br.com.tiacademy.catalogo.entity.Gravadora;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gravadora")
public class GravadoraController extends ControllerCatalogo<Gravadora, Long> {

}
