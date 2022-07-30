package br.com.tiacademy.vendas.core.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean // (essa Interface é só uma abstração)
public interface CrudRepository<T, ID> extends JpaRepository<T, ID>{

}
