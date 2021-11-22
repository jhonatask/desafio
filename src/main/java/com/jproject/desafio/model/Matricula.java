package com.jproject.desafio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;


@Entity
@Table(name = "REMATRICULA")
public class Matricula extends PanacheEntityBase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rema_id")
    private Long rema_id;
    private Long alun_id;
    private Date rema_dt_inclusao;
    private String cod_curso;
    private String nome_curso;
    private String rema_status;

//    @ManyToOne
//    @JsonBackReference
//    private PessoaFisica pessoaFisica;

    public Matricula() {
    }

    public Long getRema_id() {
        return rema_id;
    }

    public Matricula setRema_id(Long rema_id) {
        this.rema_id = rema_id;
        return this;
    }

    public Long getAlun_id() {
        return alun_id;
    }

    public Matricula setAlun_id(Long alun_id) {
        this.alun_id = alun_id;
        return this;
    }

    public Date getRema_dt_inclusao() {
        return rema_dt_inclusao;
    }

    public Matricula setRema_dt_inclusao(Date rema_dt_inclusao) {
        this.rema_dt_inclusao = rema_dt_inclusao;
        return this;
    }

    public String getCod_curso() {
        return cod_curso;
    }

    public Matricula setCod_curso(String cod_curso) {
        this.cod_curso = cod_curso;
        return this;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public Matricula setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
        return this;
    }

    public String getRema_status() {
        return rema_status;
    }

    public Matricula setRema_status(String rema_status) {
        this.rema_status = rema_status;
        return this;
    }

//    public PessoaFisica getPessoaFisica() {
//        return pessoaFisica;
//    }
//
//    public Matricula setPessoaFisica(PessoaFisica pessoaFisica) {
//        this.pessoaFisica = pessoaFisica;
//        return this;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return Objects.equals(rema_id, matricula.rema_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rema_id);
    }


    public Optional<Matricula> findByOptional(Long alun_id) {

        return find("alun_id", alun_id).firstResultOptional();
    }

}
