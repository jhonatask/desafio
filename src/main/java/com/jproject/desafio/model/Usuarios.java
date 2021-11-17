package com.jproject.desafio.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;



@Entity
@Table(name = "USUARIOS")
public class Usuarios extends PanacheEntityBase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long usu_id;
    private String usu_login;
    private String usu_pwd;
    private LocalDate usu_dtcadastro;
    private LocalDate  usu_dtexpiracao;

    @OneToOne
    @JoinColumn(name = "alun_id", referencedColumnName = "alun_id")
    @JsonBackReference
    PessoaFisica pessoaFisica;

    public Usuarios() {
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Long getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Long usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsu_login() {
        return usu_login;
    }

    public void setUsu_login(String usu_login) {
        this.usu_login = usu_login;
    }

    public String getUsu_pwd() {
        return usu_pwd;
    }

    public void setUsu_pwd(String usu_pwd) {
        this.usu_pwd = usu_pwd;
    }

    public LocalDate  getUsu_dtcadastro() {
        return usu_dtcadastro;
    }

    public void setUsu_dtcadastro(LocalDate  usu_dtcadstro) {
        this.usu_dtcadastro = usu_dtcadstro;
    }

    public LocalDate  getUsu_dtexpiracao() {
        return usu_dtexpiracao;
    }

    public void setUsu_dtexpiracao(LocalDate  usu_dtexpiracao) {
        this.usu_dtexpiracao = usu_dtexpiracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuarios = (Usuarios) o;
        return Objects.equals(usu_id, usuarios.usu_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usu_id);
    }

     public List<Usuarios> findUsu(){
        return  listAll();
     }





}
