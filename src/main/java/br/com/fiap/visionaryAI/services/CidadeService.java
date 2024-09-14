package br.com.fiap.visionaryAI.services;


import br.com.fiap.visionaryAI.dto.CidadeRequest;
import br.com.fiap.visionaryAI.dto.CidadeResponse;
import br.com.fiap.visionaryAI.models.Cidade;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    public Cidade requestToCidade(CidadeRequest cidadeRequest) {
        Cidade cidade = new Cidade();

        cidade.setNome(cidadeRequest.getNome());
        cidade.setUf(cidadeRequest.getUf());
        return cidade;
    }

    public CidadeResponse cidadeToResponse(Cidade cidade) {
        CidadeResponse cidadeResponse = new CidadeResponse();

        cidadeResponse.setId(cidade.getId());
        cidadeResponse.setNome(cidade.getNome());
        cidadeResponse.setUf(cidade.getUf());
        return cidadeResponse;
    }
}
