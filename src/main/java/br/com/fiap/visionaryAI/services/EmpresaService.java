package br.com.fiap.visionaryAI.services;

import br.com.fiap.visionaryAI.dto.EmpresaRequest;
import br.com.fiap.visionaryAI.dto.EmpresaResponse;
import br.com.fiap.visionaryAI.models.Empresa;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    public Empresa requestToEmpresa(EmpresaRequest empresaRequest){
        Empresa empresa = new Empresa();

        empresa.setCnpj(empresaRequest.getCnpj());
        empresa.setEmail(empresaRequest.getEmail());
        empresa.setNome(empresaRequest.getNome());
        empresa.setSituacao(empresaRequest.getSituacao());

        return empresa;
    }

    public EmpresaResponse empresaToResponse(Empresa empresa){
        EmpresaResponse empresaResponse = new EmpresaResponse();

        empresaResponse.setId(empresa.getId());
        empresaResponse.setCnpj(empresa.getCnpj());
        empresaResponse.setEmail(empresa.getEmail());
        empresaResponse.setNome(empresa.getNome());
        empresaResponse.setSituacao(empresa.getSituacao());

        return empresaResponse;
    }
}

