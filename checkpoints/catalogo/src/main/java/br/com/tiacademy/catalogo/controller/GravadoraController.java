package br.com.tiacademy.catalogo.controller;

import br.com.tiacademy.catalogo.dto.ArtistaDTO;
import br.com.tiacademy.catalogo.dto.GravadoraDTO;
import br.com.tiacademy.catalogo.entity.Gravadora;
import br.com.tiacademy.catalogo.repository.GravadoraRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gravadora")
public class GravadoraController extends ControllerCatalogo<Gravadora, Long> {


    @GetMapping("/dto")
    public ResponseEntity<List<GravadoraDTO>> listaDto(){
        var gravadoras = repository.findAll();

        //converter gravadora para gravadoraDTO
        var gravadorasDTO = gravadoras.stream().map(g ->
                new GravadoraDTO(
                        g.getId(),
                        g.getNome(),
                        g.getAno(),
                        g.getCidade(),
                        g.getUf(),
                        g.getArtista().stream()
                                .map(a -> new ArtistaDTO(a.getId(), a.getNome()))
                                .collect(Collectors.toList())
                )
        ).collect(Collectors.toList());

        return ResponseEntity.ok(gravadorasDTO);
    }

}
