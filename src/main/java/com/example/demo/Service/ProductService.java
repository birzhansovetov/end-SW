package com.example.demo.Service;

import com.example.demo.Dto.ProductDto;
import com.example.demo.Entity.Product;
import com.example.demo.Mapper.ProductMapper;
import com.example.demo.Repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public List<ProductDto> getAll(){
        List<Product> products = productRepo.findAll();
        List<ProductDto> productDtos = productMapper.toDtoList(products);
        return productDtos;
    }

    public ProductDto getById(Long id){
        return productMapper.toDto(productRepo.findById(id).orElse(null));
    }

    public void addProduct(ProductDto productDto){
        productRepo.save(productMapper.toEntity(productDto));
    }

    public void updateProduct(Long id,ProductDto productDto){
        Product product = productRepo.findById(id).orElse(null);
        product = Product
                .builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .category(productDto.getCategory())
                .tags(productDto.getTags())
                .build();
        productRepo.save(product);
    }

    public boolean deleteProduct(Long id){
        Product product = productRepo.findById(id).orElse(null);
        if(Objects.isNull(product)){
            return false;
        }
        productRepo.findById(id);
        return true;
    }
}
