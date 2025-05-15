package uz.rustam.training.springboot_module.service.mapper;

import org.mapstruct.Mapper;
import uz.rustam.training.springboot_module.model.dto.ProductDTO;
import uz.rustam.training.springboot_module.model.entity.Product;

@Mapper(config = BaseMapper.class)
public interface ProductMapper extends BaseMapper<Product, ProductDTO>{
}
