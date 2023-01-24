package com.paulohenrique.gerenciar_pessoas.mapper;


import com.paulohenrique.gerenciar_pessoas.dto.PessoaRequestDTO;
import com.paulohenrique.gerenciar_pessoas.dto.PessoaResponseDTO;
import com.paulohenrique.gerenciar_pessoas.model.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    Pessoa toPessoa(PessoaRequestDTO pessoaRequestDTO);

    PessoaResponseDTO toPessoaReponseDTO(Pessoa pessoa);
}
