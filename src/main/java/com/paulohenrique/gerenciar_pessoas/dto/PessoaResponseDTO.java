package com.paulohenrique.gerenciar_pessoas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class PessoaResponseDTO {

    private String id;
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
