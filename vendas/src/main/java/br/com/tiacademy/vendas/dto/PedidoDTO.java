package br.com.tiacademy.vendas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDTO implements Serializable {
    private Long id;

    private LocalDate data;
    private BigDecimal valor;

    private Long clienteId;
    private ClienteDTO cliente;

    private Long vendedorId;
    private VendedorDTO vendedor;

    private List<ItemDTO> itens = new ArrayList<>();
}
