package uz.rustam.training.springboot_module.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.rustam.training.springboot_module.model.dto.CustomerDTO;
import uz.rustam.training.springboot_module.model.entity.Customer;
import uz.rustam.training.springboot_module.repository.CustomerRepository;
import uz.rustam.training.springboot_module.service.mapper.CustomerMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerDTO create(CustomerDTO customer) {
        Customer newCustomer = customerMapper.toEntity(customer);
        return customerMapper.toDto(customerRepository.save(newCustomer));
    }

    public CustomerDTO update(Long id, CustomerDTO customer) {
        customer.setId(id);

        return customerRepository.findById(id)
                .map(existingCustpmer -> customerMapper.toEntity(customer))
                .map(customerRepository::save)
                .map(customerMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer is not found with id = " + id));
    }

    public CustomerDTO getById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer is not found with id = " + id));
    }

    public List<CustomerDTO> getAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
