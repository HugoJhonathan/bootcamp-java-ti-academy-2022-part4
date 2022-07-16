package br.com.tiacademy.vendas.service;

import br.com.tiacademy.vendas.domain.Vendedor;
import br.com.tiacademy.vendas.repository.VendedorRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VendedorService {

//    private final VendedorRepository vendedorRepository;
//    public VendedorService(VendedorRepository vendedorRepository) {
//        this.vendedorRepository = vendedorRepository;
//    }

    @Autowired
    private VendedorRepository vendedorRepository;

    public List<Vendedor> listar(){
        return vendedorRepository.findAll();
    }

    public Vendedor porId(Long id) {
        return vendedorRepository.findById(id).orElse(null);
    }
    public Vendedor criar(Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }
    public Vendedor editar(Long id, Vendedor editado){

        var recuperado = porId(id);

        if(Objects.isNull(recuperado)){
            throw new RuntimeException("id "+id+" não foi encontrado!");
        }

        recuperado.setNome(editado.getNome());

        return vendedorRepository.save(recuperado);
    }

    public void excluir(Long id){
        vendedorRepository.deleteById(id);
    }

}
