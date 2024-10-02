package com.ControleFinanceiro.ApiControleFinanceiro.Models;

import com.ControleFinanceiro.ApiControleFinanceiro.Enums.ExceptionsEnum;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Autenticacao.LoginRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Autenticacao.RegisterRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Pessoa.UpdatePessoaRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@Data
@Entity
@AllArgsConstructor
@Table(name = "tb_pessoa")
public class PessoaModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    UUID idPessoa;

    @Column(name = "nome", nullable = false, unique = true)
    String nomePessoa;

    @Column(name = "cpf", nullable = false, unique = true)
    String cpfPessoa;

    @Column(name = "email", nullable = false, unique = true)
    String emailPessoa;

    @Column(name = "telefone", nullable = false, unique = true)
    String telefonePessoa;

    @OneToMany(mappedBy = "donoGrupo", cascade = CascadeType.ALL)
    List<GrupoModel> grupos;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return null;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return null;
    }

    public PessoaModel() {
    }

    public PessoaModel(RegisterRecord registerRecord) throws Exception {

        String cpf = registerRecord.cpf().replaceAll("[^0-9]", "");
        if (!isValidCPF(cpf)) {
            throw new Exception(ExceptionsEnum.INVALID_CPF.name());
        }
        this.cpfPessoa = cpf;

        String email = registerRecord.email();
        if (!isValidEmail(email)) {
            throw new Exception(ExceptionsEnum.INVALID_EMAIL.name());
        }
        this.emailPessoa = email;

        String telefone = registerRecord.telefone().replaceAll("[^0-9]", "");
        if (!isValidTelefone(telefone)) {
            throw new Exception(ExceptionsEnum.INVALID_TELEFONE.name());
        }

        this.telefonePessoa = telefone;
        this.nomePessoa = registerRecord.nome();
    }

    public PessoaModel(UpdatePessoaRecord updatePessoaRecord) throws Exception {

        String cpf = updatePessoaRecord.cpf().replaceAll("[^0-9]", "");
        if (!isValidCPF(cpf)) {
            throw new Exception(ExceptionsEnum.INVALID_CPF.name());
        }
        this.cpfPessoa = cpf;

        String email = updatePessoaRecord.email();
        if (!isValidEmail(email)) {
            throw new Exception(ExceptionsEnum.INVALID_EMAIL.name());
        }
        this.emailPessoa = email;

        String telefone = updatePessoaRecord.telefone().replaceAll("[^0-9]", "");
        if (!isValidTelefone(telefone)) {
            throw new Exception(ExceptionsEnum.INVALID_TELEFONE.name());
        }

        this.telefonePessoa = telefone;
        this.nomePessoa = updatePessoaRecord.nome();
    }

    public PessoaModel(LoginRecord loginRecord) throws Exception {

        String cpf = loginRecord.cpf().replaceAll("[^0-9]", "");
        if (!isValidCPF(cpf)) {
            throw new Exception(ExceptionsEnum.INVALID_CPF.name());
        }
        this.cpfPessoa = cpf;

        String email = loginRecord.email();
        if (!isValidEmail(email)) {
            throw new Exception(ExceptionsEnum.INVALID_EMAIL.name());
        }
        this.emailPessoa = email;

    }

    private boolean isValidCPF(String cpf) {
        return cpf.length() == 11;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,}$";
        return Pattern.matches(emailRegex, email);
    }

    private boolean isValidTelefone(String telefone) {
        return telefone.length() >= 10;
    }

}
