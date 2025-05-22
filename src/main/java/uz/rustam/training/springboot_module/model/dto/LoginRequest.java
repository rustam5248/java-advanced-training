package uz.rustam.training.springboot_module.model.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
