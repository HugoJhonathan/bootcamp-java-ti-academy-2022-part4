package br.com.tiacademy.vendas.converter;

import br.com.tiacademy.vendas.core.crud.CrudConverter;
import br.com.tiacademy.vendas.domain.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoConverter implements CrudConverter<Pedido, Long> {

    @Override
    public Long entidadeParaDto(Pedido entidade) {
        return null;
    }

    @Override
    public Pedido dtoParaEntidade(Long dto) {
        return null;
    }
}

