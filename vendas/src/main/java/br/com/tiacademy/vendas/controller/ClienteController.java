package br.com.tiacademy.vendas.controller;

import br.com.tiacademy.vendas.domain.Cliente;
import br.com.tiacademy.vendas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos(){
        return ResponseEntity.ok(clienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarUm(@PathVariable("id") Long id){

        var cliente = clienteService.porId(id);

        if(Objects.isNull(cliente)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.criar(cliente));
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> editar(@RequestBody Cliente cliente, @PathVariable("id") Long id){
        return ResponseEntity.ok(clienteService.editar(id, cliente));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        clienteService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
