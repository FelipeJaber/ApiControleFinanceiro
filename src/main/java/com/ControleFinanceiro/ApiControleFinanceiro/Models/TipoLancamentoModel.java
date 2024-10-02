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
@Table(name = "tb_tipo_lancamento")
public class TipoLancamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tipo_lancamento_id", unique = true, updatable = false, nullable = false)
    UUID idLancamento;

    @OneToMany(mappedBy = "tipoLancamento", cascade = CascadeType.ALL)
    List<LancamentoModel> lancamentos;
}
