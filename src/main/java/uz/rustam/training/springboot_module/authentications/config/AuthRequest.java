package uz.rustam.training.springboot_module.authentications.config;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthRequest {
    private String username;
    private String password;
    private String role;
    private Boolean isActive;
}

