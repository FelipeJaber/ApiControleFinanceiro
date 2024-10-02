package com.ControleFinanceiro.ApiControleFinanceiro.Models;

import com.ControleFinanceiro.ApiControleFinanceiro.Enums.CategoriaLancamentoEnum;
import com.ControleFinanceiro.ApiControleFinanceiro.Enums.TipoLancamentoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_lancamento")
public class LancamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private UUID idLancamento;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data", columnDefinition = "TIMESTAMPTZ")
    private OffsetDateTime data;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_lancamento", nullable = false)
    private TipoLancamentoEnum tipoLancamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_lancamento", nullable = false)
    private CategoriaLancamentoEnum categoriaLancamento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable = false)
    private GrupoModel grupo;
}
