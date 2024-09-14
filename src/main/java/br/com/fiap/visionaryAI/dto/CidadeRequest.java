package br.com.fiap.visionaryAI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CidadeRequest {

    @NotBlank(message= "O nome da cidade é obrigatório")
    private String nome;

    @Size(max= 2, message = "A UF deve ter no máximo 2 caracteres")
    @NotBlank(message= "A UF é obrigatória")
    private String uf;

    public  String getNome() {
        return nome;
    }

    public void setNome( String nome) {
        this.nome = nome;
    }

    public  String getUf() {
        return uf;
    }

    public void setUf( String uf) {
        this.uf = uf;
    }
}
