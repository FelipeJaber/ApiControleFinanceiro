package com.ControleFinanceiro.ApiControleFinanceiro.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;
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
    UUID idLancamento;

    @Column(name = "nome", nullable = false)
    String nome;

    @Column(name = "descricao", nullable = false)
    String descricao;

    @Column(name = "data", columnDefinition = "TIMESTAMPTZ")
    private OffsetDateTime data;

    @Column(name = "valor", nullable = false)
    String valor;

    @ManyToOne
    @JoinColumn(name = "categoria_lancamento_id", nullable = false)
    CategoriaLancamentoModel categoriaLancamento;

    @ManyToOne
    @JoinColumn(name = "tipo_lancamento_id", nullable = false)
    TipoLancamentoModel tipoLancamento;

    @OneToMany(mappedBy = "lancamento", cascade = CascadeType.ALL)
    List<GrupoModel> grupos;
}
