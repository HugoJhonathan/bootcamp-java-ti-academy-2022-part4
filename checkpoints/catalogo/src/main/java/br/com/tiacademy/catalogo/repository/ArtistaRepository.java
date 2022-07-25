package br.com.tiacademy.catalogo.repository;

import br.com.tiacademy.catalogo.entity.Artista;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends RepositoryCatalogo<Artista, Long> {

    //                       Esse Artista é a Classe! não o nome da Tabela
    @Query(value = "SELECT a FROM Artista a WHERE a.nome = :nome")
    Artista consultarPeloNome(@Param(value="nome") String nome);

    Artista findByNome(String nome);
}
