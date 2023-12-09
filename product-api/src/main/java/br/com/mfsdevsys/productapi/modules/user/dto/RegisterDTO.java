package br.com.mfsdevsys.productapi.modules.user.dto;

import br.com.mfsdevsys.productapi.modules.user.model.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
