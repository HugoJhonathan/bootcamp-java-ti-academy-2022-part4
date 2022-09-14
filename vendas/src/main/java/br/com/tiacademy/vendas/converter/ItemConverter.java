package br.com.tiacademy.vendas.converter;

import br.com.tiacademy.vendas.core.crud.CrudConverter;
import br.com.tiacademy.vendas.domain.Item;
import br.com.tiacademy.vendas.dto.ItemDTO;
import br.com.tiacademy.vendas.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter implements CrudConverter<Item, ItemDTO> {

    @Autowired
    private ServicoConverter servicoConverter;

    @Autowired
    private ServicoRepository servicoRepository;

    @Override
    public ItemDTO entidadeParaDto(Item entidade) {

        var itemDto = new ItemDTO();
        itemDto.setId(entidade.getId());
        itemDto.setQuantidade(entidade.getQuantidade());
        itemDto.setValor(entidade.getValor());
        itemDto.setServico(servicoConverter.entidadeParaDto(entidade.getServico()));

        return itemDto;
    }

    @Override
    public Item dtoParaEntidade(ItemDTO dto) {

        var item = new Item();
        item.setId(dto.getId());
        item.setQuantidade(dto.getQuantidade());
        item.setValor(dto.getValor());
        item.setServico(servicoRepository.findById(dto.getServicoId()).orElse(null));

        return item;
    }
}
