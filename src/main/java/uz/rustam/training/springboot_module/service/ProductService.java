package uz.rustam.training.springboot_module.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.rustam.training.springboot_module.model.dto.ProductDTO;
import uz.rustam.training.springboot_module.model.entity.Product;
import uz.rustam.training.springboot_module.repository.ProductRepository;
import uz.rustam.training.springboot_module.service.mapper.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDTO create(ProductDTO product) {
        Product newProduct = productMapper.toEntity(product);
        return productMapper.toDto(productRepository.save(newProduct));
    }

    public ProductDTO update(Long id, ProductDTO product) {
        product.setId(id);

        return productRepository.findById(id)
                .map(existProduct -> productMapper.toEntity(product))
                .map(productRepository::save)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Production is not found with id = " + id));
    }

    public ProductDTO getById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Production is not found with id = " + id));
    }

    public List<ProductDTO> getAllProduct() {

        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
