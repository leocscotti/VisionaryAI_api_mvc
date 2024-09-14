package br.com.fiap.visionaryAI.controllers;


import br.com.fiap.visionaryAI.dto.CidadeRequest;
import br.com.fiap.visionaryAI.dto.CidadeResponse;
import br.com.fiap.visionaryAI.models.Cidade;
import br.com.fiap.visionaryAI.repository.CidadeRepository;
import br.com.fiap.visionaryAI.services.CidadeService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<CidadeResponse> criarCidade(@RequestBody @Valid CidadeRequest cidadeRequest) {
        Cidade cidade= cidadeService.requestToCidade(cidadeRequest);
        Cidade novaCidade= cidadeRepository.save(cidade);
        CidadeResponse cidadeResponse= cidadeService.cidadeToResponse(novaCidade);
        return ResponseEntity.ok(cidadeResponse);
    }

    @GetMapping
    public ResponseEntity<List<CidadeResponse>> listarCidades() {
        List<Cidade> cidades = cidadeRepository.findAll();
        List<CidadeResponse> cidadeResponses= cidades.stream()
                .map(cidadeService:: cidadeToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cidadeResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeResponse> buscarCidadePorId(@PathVariable Long id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        if (cidade.isPresent()) {
            CidadeResponse cidadeResponse= cidadeService.cidadeToResponse(cidade.get());
            return ResponseEntity.ok(cidadeResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CidadeResponse> atualizarCidade(@PathVariable Long id, @RequestBody @Valid CidadeRequest cidadeRequest) {
        Optional<Cidade> optionalCidade = cidadeRepository.findById(id);
        if (optionalCidade.isPresent()) {
            Cidade cidade= optionalCidade.get();
            cidade.setNome(cidadeRequest.getNome());
            cidade.setUf(cidadeRequest.getUf());
            Cidade cidadeAtualizada= cidadeRepository.save(cidade);
            CidadeResponse cidadeResponse= cidadeService.cidadeToResponse(cidadeAtualizada);
            return ResponseEntity.ok(cidadeResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCidade(@PathVariable Long id) {
        Optional<Cidade> optionalCidade = cidadeRepository.findById(id);
        if (optionalCidade.isPresent()) {
            cidadeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
