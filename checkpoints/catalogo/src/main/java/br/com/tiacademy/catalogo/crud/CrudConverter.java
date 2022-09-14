package br.com.tiacademy.catalogo.crud;

//                          entidade, DTO
public interface CrudConverter<T, D>{
    D entidadeParaDto(T entidade);
    T dtoParaEntidade(D dto);
}

