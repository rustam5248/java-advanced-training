package uz.rustam.training.springboot_module.model.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private Long id;
    private String customerName;
    private String email;
    private String phoneNumber;
}
