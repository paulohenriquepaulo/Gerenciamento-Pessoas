package com.paulohenrique.gerenciar_pessoas.mapper;


import com.paulohenrique.gerenciar_pessoas.dto.EnderecoResponseDTO;
import com.paulohenrique.gerenciar_pessoas.dto.EnderecoResquestDTO;
import com.paulohenrique.gerenciar_pessoas.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    @Mapping(target = "pessoa.id", source = "idPessoa")
    Endereco toEndereco(EnderecoResquestDTO dto);

    @Mapping(target = "endereco.pessoa", source = "pessoa")
    @Mapping(target = "endereco.rua", source = "rua")
    @Mapping(target = "endereco.id", source = "id")
    @Mapping(target = "endereco.bairro", source = "bairro")
    @Mapping(target = "endereco.numero", source = "numero")
    @Mapping(target = "endereco.cidade", source = "cidade")
    @Mapping(target = "endereco.estado", source = "estado")
    @Mapping(target = "endereco.cep", source = "cep")
    EnderecoResponseDTO toEnderecoResponse(Endereco endereco);

}
