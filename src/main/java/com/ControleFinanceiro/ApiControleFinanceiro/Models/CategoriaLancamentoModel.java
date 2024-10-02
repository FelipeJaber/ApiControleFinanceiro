package com.ControleFinanceiro.ApiControleFinanceiro.Models;

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
@Table(name = "tb_categoria_lancamento")
public class CategoriaLancamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    UUID idCategoriaLancamento;

    @Column(name = "nome_lancamento", nullable = false, unique = true)
    String nomeLancamento;

    @Column(name = "descricao", nullable = false)
    String descricao;

    @OneToMany(mappedBy = "categoriaLancamento", cascade = CascadeType.ALL)
    List<LancamentoModel> lancamentos;

    @OneToMany(mappedBy = "categoriaLancamento", cascade = CascadeType.ALL)
    List<MetaModel> metas;
}
