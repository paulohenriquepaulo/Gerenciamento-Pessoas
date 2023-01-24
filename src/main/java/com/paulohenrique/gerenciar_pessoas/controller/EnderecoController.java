package com.paulohenrique.gerenciar_pessoas.controller;

import com.paulohenrique.gerenciar_pessoas.dto.EnderecoResponseDTO;
import com.paulohenrique.gerenciar_pessoas.dto.EnderecoResquestDTO;
import com.paulohenrique.gerenciar_pessoas.mapper.EnderecoMapper;
import com.paulohenrique.gerenciar_pessoas.model.Endereco;
import com.paulohenrique.gerenciar_pessoas.service.EnderecoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> cadastrarEndereco(@RequestBody EnderecoResquestDTO resquestDTO) throws IOException {
        Endereco novoEndereco = enderecoService.cadastrarEndereco(enderecoMapper.toEndereco(resquestDTO));
        EnderecoResponseDTO responseDTO = enderecoMapper.toEnderecoResponse(novoEndereco);
        return ResponseEntity.ok(responseDTO);
    }
}
