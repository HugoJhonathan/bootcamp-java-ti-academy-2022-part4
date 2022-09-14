package br.com.tiacademy.vendas.repository;

import br.com.tiacademy.vendas.core.crud.CrudRepository;
import br.com.tiacademy.vendas.domain.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    //HQL
    @Query("select i from Item i where i.id in (:ids)")
    List<Item> recuperarPorIds(@Param("") List<Long> ids);

    //Query Nativa (acoplada ao BD)
    @Query(nativeQuery = true, value = "select * from item where id in (:ids)")
    List<Item> recuperarPorIdsNativo(@Param("ids") List<Long> ids);

    //Spring Data
    List<Item> findByIdIn(List<Long> ids);

}
