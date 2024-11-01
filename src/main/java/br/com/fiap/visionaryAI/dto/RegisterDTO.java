package br.com.fiap.visionaryAI.dto;

import br.com.fiap.visionaryAI.models.UserRole;

public record RegisterDTO(String login, String senha, UserRole role) {
}
