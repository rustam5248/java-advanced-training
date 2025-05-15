package uz.rustam.training.springboot_module.service.mapper;

import org.mapstruct.Mapper;
import uz.rustam.training.springboot_module.model.dto.CustomerDTO;
import uz.rustam.training.springboot_module.model.entity.Customer;

@Mapper(config = BaseMapper.class)
public interface CustomerMapper extends BaseMapper<Customer, CustomerDTO> {
}
