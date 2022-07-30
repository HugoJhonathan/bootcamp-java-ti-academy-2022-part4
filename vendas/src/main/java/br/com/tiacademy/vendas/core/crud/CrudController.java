package br.com.tiacademy.vendas.core.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class CrudController<T extends CrudDomain<ID>, D,ID> {

    @Autowired
    protected CrudService<T, ID> service;

    @Autowired
    protected  CrudConverter<T, D> converter;

    @GetMapping
    public ResponseEntity<Page<D>> paginada(Pageable pageable){
        var listaPaginada= service.paginada(pageable).map(converter::entidadeParaDto);
        return ResponseEntity.ok(listaPaginada);
    }


    @GetMapping("/lista")
    public ResponseEntity<List<D>> listarTodos(){

//        ## Maneira mais antiga de fazer, antes da versão 8 ##
//        List<D> listaDto = new ArrayList<>();
//        for(T entidade : listaEntidade){
//            var dto = converter.entidadeParaDto(entidade);
//            listaDto.add(dto);
//        }
//        return ResponseEntity.ok(listaDto);



        var ListaDto= service.listar()
                .stream()
                .map(converter::entidadeParaDto) // item por item, converte
                .collect(Collectors.toList()); // transforma tudo isso em uma coleção de Lista
        // percorre a lista, e pra cada item chama o metodo do converter


        return ResponseEntity.ok(ListaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> listarUm(@PathVariable("id") ID id){

        var entidade = service.porId(id);

        if(Objects.isNull(entidade)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(converter.entidadeParaDto(entidade));
    }

    @PostMapping
    public ResponseEntity<D> criar(@RequestBody D dto){
        // conveter pra entidade, salvar, e rotornar convertido pra DTO
        var entidade = converter.dtoParaEntidade(dto); // converte dto para entidade
        var salvo = service.criar(entidade); // salva essa entidade
        var salvoDto = converter.entidadeParaDto(salvo); // converte o que foi salvo para Dto e retorna

        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
        var uri = builder.path("/{id}").buildAndExpand(salvo.getId()).toUri(); // id da entity criada
        return ResponseEntity.created(uri).body(salvoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> editar(@RequestBody D dto, @PathVariable("id") ID id){

        var novaEntidade = converter.dtoParaEntidade(dto);
        var salvo = service.editar(id, novaEntidade);
        var salvoDto = converter.entidadeParaDto(salvo);

        return ResponseEntity.ok(salvoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") ID id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
