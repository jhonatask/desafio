package com.jproject.desafio.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "PESSOA_FISICA")
public class PessoaFisica extends PanacheEntityBase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alun_id")
    private Long alun_id;
    private String alun_dt_nascimento;
    private String alun_nome;
    private String alun_email;
    private String alun_cpf;
    private String alun_telefone1;
    private String alun_telefone2;

    public PessoaFisica() {
    }

    public Long getAlun_id() {
        return alun_id;
    }

    public void setAlun_id(Long alun_id) {
        this.alun_id = alun_id;
    }

    public String getAlun_dt_nascimento() {
        return alun_dt_nascimento;
    }

    public void setAlun_dt_nascimento(String alun_dt_nascimento) {
        this.alun_dt_nascimento = alun_dt_nascimento;
    }

    public String getAlun_nome() {
        return alun_nome;
    }

    public void setAlun_nome(String alun_nome) {
        this.alun_nome = alun_nome;
    }

    public String getAlun_email() {
        return alun_email;
    }

    public void setAlun_email(String alun_email) {
        this.alun_email = alun_email;
    }

    public String getAlun_cpf() {
        return alun_cpf;
    }

    public void setAlun_cpf(String alun_cpf) {
        this.alun_cpf = alun_cpf;
    }

    public String getAlun_telefone1() {
        return alun_telefone1;
    }

    public void setAlun_telefone1(String alun_telefone1) {
        this.alun_telefone1 = alun_telefone1;
    }

    public String getAlun_telefone2() {
        return alun_telefone2;
    }

    public void setAlun_telefone2(String alun_telefone2) {
        this.alun_telefone2 = alun_telefone2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaFisica that = (PessoaFisica) o;
        return Objects.equals(alun_id, that.alun_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alun_id);
    }
}
