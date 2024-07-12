package com.logonedigital.gestion_stock_api.product;

import com.logonedigital.gestion_stock_api.product.application.ProductDTO;
import com.logonedigital.gestion_stock_api.product.application.SaveProductRequest;
import com.logonedigital.gestion_stock_api.product.application.SaveProductResponse;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getProducts() {
        return productRepository.findAll().stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public SaveProductResponse saveProduct(SaveProductRequest request) {
        SaveProductResponse response = new SaveProductResponse();
        try {
            ProductEntity product = new ProductEntity();
            product.setName(request.getName());
            product.setDescription(request.getDescription());
            product.setPrice(request.getPrice());
            product.setQuantity(request.getQuantity());
            product.setCreatedAt(new Date());
            product.setUpdatedAt(new Date());
            productRepository.save(product);
            response.setSaved(true);
            response.setMessage("Product saved successfully.");
            response.setProductId(product.getId());
        } catch (Exception e) {
            response.setMessage("Error saving product: " + e.getMessage());
        }
        return response;
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        return productRepository.findById(id)
                .map(this::convertEntityToDTO)
                .orElse(null);
    }

    @Override
    public SaveProductResponse updateProduct(Integer id, SaveProductRequest request) {
        SaveProductResponse response = new SaveProductResponse();
        try {
            ProductEntity product = productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Product not found."));
            product.setName(request.getName());
            product.setDescription(request.getDescription());
            product.setPrice(request.getPrice());
            product.setQuantity(request.getQuantity());
            product.setUpdatedAt(new Date());
            productRepository.save(product);
            response.setSaved(true);
            response.setMessage("Product updated successfully.");
            response.setProductId(product.getId());
        } catch (Exception e) {
            response.setMessage("Error updating product: " + e.getMessage());
        }
        return response;
    }

    @Override
    public SaveProductResponse deleteProduct(Integer id) {
        SaveProductResponse response = new SaveProductResponse();
        try {
            productRepository.deleteById(id);
            response.setSaved(true);
            response.setMessage("Product deleted successfully.");
        } catch (Exception e) {
            response.setMessage("Error deleting product: " + e.getMessage());
        }
        return response;
    }

    private ProductDTO convertEntityToDTO(ProductEntity entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}

