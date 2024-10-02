package com.ControleFinanceiro.ApiControleFinanceiro.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_grupo")
public class GrupoModel {
    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    UUID idGrupo;

    @Column(name = "nome", unique = true, nullable = false)
    String nomeGrupo;

    @Column(name = "descricao", nullable = false)
    String descricaoGrupo;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "dono_id", nullable = false)
    PessoaModel donoGrupo;
}
