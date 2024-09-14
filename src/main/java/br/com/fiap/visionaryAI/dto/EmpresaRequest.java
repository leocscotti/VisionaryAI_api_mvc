package br.com.fiap.visionaryAI.dto;

import jakarta.validation.constraints.*;

public class EmpresaRequest {

    @Size(min= 14, message="O CNPJ é inválido")
    private String cnpj;

    @Email(message= "email inválido")
    private String email;

    @NotBlank(message = "O nome da empresa é obrigatório")
    private String nome;

    @NotBlank(message = "a situação da empresa é obrigatória")
    private String situacao;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
