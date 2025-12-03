package com.example.demo.Controller;

import com.example.demo.Dto.ProductDto;
import com.example.demo.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductApi {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByID(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(productService.getById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addProducts(@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProducts(@PathVariable(name = "id") Long id,
                                            @RequestBody ProductDto productDto){
        productService.updateProduct(id,productDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
    }
}
