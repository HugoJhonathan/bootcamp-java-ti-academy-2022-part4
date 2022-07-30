package br.com.tiacademy.vendas.converter;

import br.com.tiacademy.vendas.core.crud.CrudConverter;
import br.com.tiacademy.vendas.domain.Vendedor;
import br.com.tiacademy.vendas.dto.VendedorDTO;
import org.springframework.stereotype.Component;

@Component // essa classe é um component também, e será gerenciado pelo Spring
public class VendedorConverter implements CrudConverter<Vendedor, VendedorDTO> {
    @Override
    public VendedorDTO entidadeParaDto(Vendedor entidade) {
//        Método [1]
//        var dto = new VendedorDTO();
//        dto.setId(entidade.getId());
//        dto.setName(entidade.getNome());
//        return dto;

//        Método [2]
        return new VendedorDTO(entidade.getId(), entidade.getNome());
    }

    @Override
    public Vendedor dtoParaEntidade(VendedorDTO dto) {
        return new Vendedor(dto.getId(), dto.getNome());
    }


}
