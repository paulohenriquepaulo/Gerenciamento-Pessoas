package com.paulohenrique.gerenciar_pessoas.service;

import com.google.gson.Gson;
import com.paulohenrique.gerenciar_pessoas.dto.EnderecoDTO;
import com.paulohenrique.gerenciar_pessoas.exeception.ExeceptionPersonalizada;
import com.paulohenrique.gerenciar_pessoas.model.Endereco;
import com.paulohenrique.gerenciar_pessoas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;
    static String webService = "https://viacep.com.br/ws/";
    static int codigoSucesso = 200;

    public Endereco cadastrarEndereco(Endereco endereco) throws IOException {
        endereco.setPessoa(pessoaService.buscarPessoaPorId(endereco.getPessoa().getId()));
        EnderecoDTO enderecoDTO = buscarEnderecoPeloCep(endereco.getCep());
        endereco.setCidade(enderecoDTO.getLocalidade());
        endereco.setEstado(enderecoDTO.getUf());
        endereco.setBairro(enderecoDTO.getBairro());
        return enderecoRepository.save(endereco);
    }
    private EnderecoDTO buscarEnderecoPeloCep(String cep) throws IOException {
        String urlChamada = webService + cep + "/json";
        URL url = new URL(urlChamada);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection.getResponseCode() != codigoSucesso) {
            throw new ExeceptionPersonalizada("CEP invalido" , HttpStatus.NOT_FOUND);
        }
        BufferedReader resposta = new BufferedReader
                (new InputStreamReader((connection.getInputStream())));

        String jsonEmString = Util.converterJsonEmString(resposta);
        Gson gson = new Gson();
        EnderecoDTO endereco = gson.fromJson(jsonEmString, EnderecoDTO.class);

        return endereco;
    }
}
