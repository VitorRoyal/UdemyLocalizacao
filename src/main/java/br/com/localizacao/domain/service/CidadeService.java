package br.com.localizacao.domain.service;

import br.com.localizacao.domain.entity.Cidade;
import br.com.localizacao.domain.repository.CidadeRepository;
import br.com.localizacao.domain.repository.specs.CidadeSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public void listarCidadePorHabitantes(){
        cidadeRepository.findByHabitantes(12000000L).forEach(System.out::println);
        cidadeRepository.findByHabitantesMoreThan(1000000L).forEach(System.out::println);
    }

    public void listarCidadesPorNome(){
        cidadeRepository.findByNome("São Paulo").forEach(System.out::println);
        cidadeRepository.findByNomeStartingWith("Porto").forEach(System.out::println);
        cidadeRepository.findByNomeEndingWith("ia").forEach(System.out::println);
        cidadeRepository.findByNomeContaining("de").forEach(System.out::println);
    }

    public void salvarCidade(){
        Cidade cidade = new Cidade(1L, "São Paulo", 12_000_000L);
        cidadeRepository.save(cidade);
    }

    public void listarCidade(){
        cidadeRepository.findAll().forEach(System.out::println);
    }

    //Testando o filtro dinâmico com Example
    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Cidade> example = Example.of(cidade, matcher);
        return cidadeRepository.findAll(example);

    }

    public void listarCidadesByNomeSpecs(){
        cidadeRepository.findAll(CidadeSpecs.nomeEqual("São Paulo")
                        .and(CidadeSpecs.habitantesGreaterThan(1000L)))
                .forEach(System.out::println);
    }

    public void listarCidadesSpecsFiltroDinamico(Cidade cidade){
        Specification<Cidade> spec = Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());

        if(StringUtils.hasText(cidade.getNome())){
            spec = spec.and(CidadeSpecs.nomeLike(cidade.getNome()));
        }

        if(cidade.getHabitantes() != null){
            spec = spec.and(CidadeSpecs.habitantesGreaterThan(cidade.getHabitantes()));
        }

        cidadeRepository.findAll(spec).forEach(System.out::println);


    }

}
