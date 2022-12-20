package com.lmSports.algaworksapi.LmSportsapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categoria")
public abstract class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    private String nome;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
