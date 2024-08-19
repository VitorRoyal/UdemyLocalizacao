package br.com.localizacao.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cidade")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cidade {
    @Id
    private Long id;
    private String nome;
    private Long habitantes;
}
