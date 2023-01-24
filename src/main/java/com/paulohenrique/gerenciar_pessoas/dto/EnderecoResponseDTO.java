package com.paulohenrique.gerenciar_pessoas.dto;

import com.paulohenrique.gerenciar_pessoas.model.Endereco;
import com.paulohenrique.gerenciar_pessoas.model.Pessoa;

public class EnderecoResponseDTO {
    Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
