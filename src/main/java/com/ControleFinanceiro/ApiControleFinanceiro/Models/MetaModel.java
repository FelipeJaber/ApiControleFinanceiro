package com.ControleFinanceiro.ApiControleFinanceiro.Models;

import com.ControleFinanceiro.ApiControleFinanceiro.Enums.TipoLancamentoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_meta")
public class MetaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable = false)
    private GrupoModel grupo;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_lancamento", nullable = false)
    private TipoLancamentoEnum tipoLancamento;
}
