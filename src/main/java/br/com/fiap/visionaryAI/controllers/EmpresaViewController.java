package br.com.fiap.visionaryAI.controllers;

import br.com.fiap.visionaryAI.dto.EmpresaResponse;
import br.com.fiap.visionaryAI.models.Empresa;
import br.com.fiap.visionaryAI.repository.EmpresaRepository;
import br.com.fiap.visionaryAI.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
}
