package com.logonedigital.gestion_stock_api.product;

import com.logonedigital.gestion_stock_api.product.application.ProductDTO;
import com.logonedigital.gestion_stock_api.product.application.SaveProductRequest;
import com.logonedigital.gestion_stock_api.product.application.SaveProductResponse;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ProductService {
   // List<ProductEntity> getProducts();
    List<ProductDTO> getProducts();
    SaveProductResponse saveProduct(SaveProductRequest request);
    ProductDTO getProductById(Integer id);
    SaveProductResponse updateProduct(Integer id, SaveProductRequest request);
    SaveProductResponse deleteProduct(Integer id);
}

