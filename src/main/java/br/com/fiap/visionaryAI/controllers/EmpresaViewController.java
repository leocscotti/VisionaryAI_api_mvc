package br.com.fiap.visionaryAI.controllers;

import br.com.fiap.visionaryAI.dto.EmpresaRequest;
import br.com.fiap.visionaryAI.dto.EmpresaResponse;
import br.com.fiap.visionaryAI.models.Empresa;
import br.com.fiap.visionaryAI.repository.EmpresaRepository;
import br.com.fiap.visionaryAI.services.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class EmpresaViewController {

    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/listaEmpresas")
    public ModelAndView listaEmpresas(){
        List<Empresa> listaEmpresas= empresaRepository.findAll();
        List<EmpresaResponse> listaEmpresasResponse= new ArrayList<>();
        for (Empresa empresa: listaEmpresas){
            listaEmpresasResponse.add(empresaService.empresaToResponse(empresa));
        }

        ModelAndView mv= new ModelAndView("empresas");
        mv.addObject("listaEmpresas", listaEmpresasResponse);
        return mv;
    }

    @GetMapping("/template")
    public String template(){
        return "templateVazio";
    }

    @GetMapping("/listaEmpresasTemplate")
    public ModelAndView listaEmpresasTemplate(){
        List<Empresa> listaEmpresas= empresaRepository.findAll();
        List<EmpresaResponse> listaEmpresasResponse= new ArrayList<>();
        for (Empresa empresa: listaEmpresas){
            listaEmpresasResponse.add(empresaService.empresaToResponse(empresa));
        }

        ModelAndView mv= new ModelAndView("template");
        mv.addObject("page", "empresas");
        mv.addObject("content", "listaEmpresas");
        mv.addObject("listaEmpresas", listaEmpresasResponse);
        return mv;
    }

    @GetMapping("/cadastroEmpresa")
    public ModelAndView cadastroEmpresa() {
        ModelAndView mv= new ModelAndView("template");
        mv.addObject("page", "empresaCadastro");
        mv.addObject("content", "formCadastro");
        mv.addObject("empresaRequest", new EmpresaRequest());
        return mv;
    }

    @PostMapping("/cadastrarEmpresa")
    public ModelAndView cadastrarEmpresa(@Valid @ModelAttribute EmpresaRequest empresaRequest) {
        Empresa empresa= empresaService.requestToEmpresa(empresaRequest);
        empresaRepository.save(empresa);
        return listaEmpresasTemplate();
    }

    @GetMapping("/editarEmpresa/{id}")
    public ModelAndView editarEmpresa(@PathVariable Long id) {
        Optional<Empresa> empresa= empresaRepository.findById(id);
        if (empresa.isEmpty()) {
            return listaEmpresasTemplate();
        }
        ModelAndView mv= new ModelAndView("template");
        mv.addObject("page", "empresaEdicao");
        mv.addObject("content", "formEdicao");
        mv.addObject("empresaRequest", empresaService.empresaToRequest(empresa.get()));
        mv.addObject("idEmpresa", id);
        return mv;
    }

    @PostMapping("/atualizarEmpresa/{id}")
    public ModelAndView atualizarEmpresa(@PathVariable Long id, @Valid @ModelAttribute EmpresaRequest empresaRequest) {
        if (empresaRepository.findById(id).isEmpty()) {
            return listaEmpresasTemplate();
        }
        Empresa empresa= empresaService.requestToEmpresa(empresaRequest);
        empresa.setId(id);
        empresaRepository.save(empresa);
        return listaEmpresasTemplate();
    }

    @GetMapping("/deletarEmpresa/{id}")
    public ModelAndView deletarEmpresa(@PathVariable Long id) {
        Optional<Empresa> empresa= empresaRepository.findById(id);
        if (empresa.isEmpty()){
            return listaEmpresasTemplate();
        }
        empresaRepository.delete(empresa.get());
        return listaEmpresasTemplate();
    }
}
