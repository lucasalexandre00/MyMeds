package br.edu.ifsp.mymeds.model;

import java.time.ZonedDateTime;

public class Medicamento {

    private String nome;
    private String descricao;

    private String dosagem;

    private ZonedDateTime horarios;

    public Medicamento(String nome, String descricao, String dosagem, ZonedDateTime horarios) {
        this.nome = nome;
        this.descricao = descricao;
        this.dosagem = dosagem;
        this.horarios = horarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
