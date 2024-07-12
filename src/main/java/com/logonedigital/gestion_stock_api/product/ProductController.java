package com.logonedigital.gestion_stock_api.product;

import com.logonedigital.gestion_stock_api.product.application.ProductDTO;
import com.logonedigital.gestion_stock_api.product.application.SaveProductRequest;
import com.logonedigital.gestion_stock_api.product.application.SaveProductResponse;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/produits")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    @ResponseBody
    public List<ProductDTO> getAllProducts() {
        return this.productService.getProducts();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ProductDTO getProductById(@PathVariable Integer id) {
        return this.productService.getProductById(id);
    }

    @PostMapping("/ajouter")
    @ResponseBody
    public SaveProductResponse addProduct(@Valid @RequestBody SaveProductRequest request, BindingResult result) {
        if (result.hasErrors()) {
            return createErrorResponse(result);
        }
        return this.productService.saveProduct(request);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public SaveProductResponse updateProduct(@PathVariable Integer id, @Valid @RequestBody SaveProductRequest request, BindingResult result) {
        if (result.hasErrors()) {
            return createErrorResponse(result);
        }
        return this.productService.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public SaveProductResponse deleteProduct(@PathVariable Integer id) {
        return this.productService.deleteProduct(id);
    }

    private SaveProductResponse createErrorResponse(BindingResult result) {
        SaveProductResponse response = new SaveProductResponse();
        response.setMessage("Validation errors: " + result.getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + " " + fieldError.getDefaultMessage())
                .reduce((msg1, msg2) -> msg1 + ", " + msg2).orElse(""));
        return response;
    }
}
