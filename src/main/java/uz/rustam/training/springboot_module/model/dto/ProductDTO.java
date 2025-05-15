package uz.rustam.training.springboot_module.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private Long id;
    private String productName;
    private String productDescription;
    private BigDecimal price;
    private int quantity;

}
