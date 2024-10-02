package com.ControleFinanceiro.ApiControleFinanceiro.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private List<LancamentoModel> lancamentos;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private List<MetaModel> metas;

}
