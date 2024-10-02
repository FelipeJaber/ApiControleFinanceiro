package com.ControleFinanceiro.ApiControleFinanceiro.Models;

import com.ControleFinanceiro.ApiControleFinanceiro.Enums.TipoLancamentoEnum;
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
@Table(name = "tb_meta")
public class MetaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    UUID idMeta;

    @OneToMany(mappedBy = "meta", cascade = CascadeType.ALL)
    List<GrupoModel> grupos;

    @Column(name = "valor", nullable = false)
    String valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_lancamento", nullable = false)
    TipoLancamentoEnum tipoLancamento;
}
