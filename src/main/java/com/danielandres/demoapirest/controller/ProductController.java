package com.danielandres.demoapirest.controller;

import com.danielandres.demoapirest.domain.Product;
import com.danielandres.demoapirest.dto.ProductDTO;
import com.danielandres.demoapirest.service.ProductService;
import com.danielandres.demoapirest.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ModelMapper modelMapper;

    @Operation(summary = "Get the products by category")
    @GetMapping(value = "/products")
    public ResponseEntity<Set<ProductDTO>> getProducts(@RequestParam(value = "category", defaultValue = "") String category) {

        Set<Product> products;

        if (category.trim().equals("")) {
            products = productService.findAllProductsVisible(true);
        } else {
            products = productService.findByCategory(category);
            if (products.size() == 0)
                throw new IllegalArgumentException("The argument provided does not exist");
        }

        Set<ProductDTO> productsDTO = products.stream().map(this::covertToDTO).collect(Collectors.toSet());
        return new ResponseEntity<>(productsDTO, HttpStatus.OK);

    }

    @Operation(summary = "Add a product")
    @PostMapping(value = "/products")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO) {

        Product product = convertToEntity(productDTO);

        Product productAdd = productService.addProduct(product);

        return new ResponseEntity<>(productAdd, HttpStatus.OK);
    }

    @Operation(summary = "Modify the name of a product by the id")
    @PatchMapping(value = "/products/{id}")
    public ResponseEntity<ProductDTO> modifyProduct(@PathVariable long id, @RequestBody ProductDTO productDTO) {

        Product product = convertToEntity(productDTO);

        productService.updateProductName(id, product.getName());

        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @Operation(summary = "Delete a product by id")
    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<ResponseUtil> deleteProduct(@PathVariable long id) {

        productService.deleteProduct(id);

        ResponseUtil responseUtil = ResponseUtil.builder().message("Producto eliminado").errorCode(ResponseUtil.NO_ERROR).build();
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);
    }

    private ProductDTO covertToDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    private Product convertToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
