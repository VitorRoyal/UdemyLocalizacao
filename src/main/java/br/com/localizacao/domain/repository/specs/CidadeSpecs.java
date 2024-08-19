package br.com.localizacao.domain.repository.specs;

import br.com.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

public abstract class CidadeSpecs {

    //pega qualquer propriedade e compara com o valor
    public static Specification<Cidade> propertyEqual(String prop, Object value){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(prop), value));
    }

    public static Specification<Cidade> nomeEqual(String nome){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("nome"), nome));
    }

    public static Specification<Cidade> habitantesGreaterThan(Long habitantes){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("habitantes"), habitantes));
    }

    public static Specification<Cidade> nomeLike(String nome){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("nome")),"%" + nome + "%".toUpperCase());
    }
}
