package br.com.localizacao.domain.repository;

import br.com.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor<Cidade> {

    //Brincando com QueryMethods e Querys com JPQL

    @Query("SELECT c FROM Cidade c WHERE c.nome = :nome")
    List<Cidade> findByNome(String nome);

    //Busca por nome que começa com o valor informado
    @Query("SELECT c FROM Cidade c WHERE c.nome LIKE :nome%")
    List<Cidade> findByNomeStartingWith(String nome);

    //Busca por nome que termina com o valor informado
    @Query("SELECT c FROM Cidade c WHERE c.nome LIKE %:nome")
    List<Cidade> findByNomeEndingWith(String nome);

    //Busca por nome que contém o valor informado
    @Query("SELECT c FROM Cidade c WHERE c.nome LIKE %:nome%")
    List<Cidade> findByNomeContaining(String nome);
    
    @Query("SELECT c FROM Cidade c Where c.nome LIKE :nome")
    List<Cidade> findByNomeLike(String nome);

    @Query("SELECT c FROM Cidade c WHERE c.habitantes = :habitantes")
    List<Cidade> findByHabitantes(Long habitantes);

    @Query("SELECT c From Cidade c Where c.habitantes > :habitantes")
    List<Cidade> findByHabitantesMoreThan(Long habitantes);

    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String porto);
}
