package uz.rustam.training.springboot_module.authentications.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AuthResponse {
    private String token;
    private List<String> roles;

    public AuthResponse(String token, List<String> roles) {
        this.token = token;
        this.roles = roles;
    }
}
