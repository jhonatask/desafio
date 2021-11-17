package com.jproject.desafio.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Optional;


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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "pessoaFisica")
    @JsonManagedReference
    Usuarios usuarios;

    public PessoaFisica() {
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
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


    public static boolean isCPF(String alun_cpf) {
        // considera-se erro alun_cpf's formados por uma sequencia de numeros iguais
        if (alun_cpf.equals("00000000000") ||
                alun_cpf.equals("11111111111") ||
                alun_cpf.equals("22222222222") || alun_cpf.equals("33333333333") ||
                alun_cpf.equals("44444444444") || alun_cpf.equals("55555555555") ||
                alun_cpf.equals("66666666666") || alun_cpf.equals("77777777777") ||
                alun_cpf.equals("88888888888") || alun_cpf.equals("99999999999") ||
                (alun_cpf.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do alun_cpf em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (alun_cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (alun_cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == alun_cpf.charAt(9)) && (dig11 == alun_cpf.charAt(10)))
                return (true);
            else return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public String imprimeCPF(String alun_cpf) {
        return (alun_cpf.substring(0, 3) + "." + alun_cpf.substring(3, 6) + "." +
                alun_cpf.substring(6, 9) + "-" + alun_cpf.substring(9, 11));
    }

    public Optional<PessoaFisica> findByOptional(String alun_cpf) {

        return find("alun_cpf", alun_cpf).firstResultOptional();
    }


}
