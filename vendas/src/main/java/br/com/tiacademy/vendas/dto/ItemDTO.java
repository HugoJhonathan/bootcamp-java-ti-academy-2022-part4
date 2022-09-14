package br.com.tiacademy.vendas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements Serializable {
    private Long id;
    private Integer quantidade;
    private BigDecimal valor;
    private ServicoDTO servico;
    private Long servicoId;
}
