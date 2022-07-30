package br.com.tiacademy.vendas.domain;

import br.com.tiacademy.vendas.core.crud.CrudDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

// @Table(name = "vendedor") // Se a Classe não tiver o mesmo nome da Tabela do BD, precisa definir com essa annotation
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vendedor implements CrudDomain<Long>, Serializable {

    @Id // PrimaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

//    private String email;
//
//    private String senha;

}

