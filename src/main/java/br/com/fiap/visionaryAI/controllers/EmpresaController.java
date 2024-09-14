package br.com.fiap.visionaryAI.controllers;

import br.com.fiap.visionaryAI.dto.EmpresaRequest;
import br.com.fiap.visionaryAI.dto.EmpresaResponse;
import br.com.fiap.visionaryAI.models.Empresa;
import br.com.fiap.visionaryAI.services.EmpresaService;
import br.com.fiap.visionaryAI.repository.EmpresaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaService empresaService;


    @PostMapping
    public ResponseEntity<EmpresaResponse> criarEmpresa(@RequestBody @Valid EmpresaRequest empresaRequest) {
        Empresa empresa = empresaService.requestToEmpresa(empresaRequest);
        Empresa novaEmpresa = empresaRepository.save(empresa);
        EmpresaResponse empresaResponse = empresaService.empresaToResponse(novaEmpresa);
        return ResponseEntity.ok(empresaResponse);
    }


    @GetMapping
    public ResponseEntity<List<EmpresaResponse>> listarEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        List<EmpresaResponse> empresaResponses = empresas.stream()
                .map(empresaService::empresaToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(empresaResponses);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponse> buscarEmpresaPorId(@PathVariable Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if (empresa.isPresent()) {
            EmpresaResponse empresaResponse = empresaService.empresaToResponse(empresa.get());
            return ResponseEntity.ok(empresaResponse);
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<EmpresaResponse> atualizarEmpresa(@PathVariable Long id, @RequestBody @Valid EmpresaRequest empresaRequest) {
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
        if (optionalEmpresa.isPresent()) {
            Empresa empresa = optionalEmpresa.get();
            empresa.setCnpj(empresaRequest.getCnpj());
            empresa.setEmail(empresaRequest.getEmail());
            empresa.setNome(empresaRequest.getNome());
            empresa.setSituacao(empresaRequest.getSituacao());
            Empresa empresaAtualizada = empresaRepository.save(empresa);
            EmpresaResponse empresaResponse = empresaService.empresaToResponse(empresaAtualizada);
            return ResponseEntity.ok(empresaResponse);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if (empresa.isPresent()) {
            empresaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
