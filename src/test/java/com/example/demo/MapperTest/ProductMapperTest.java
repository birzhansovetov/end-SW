package com.example.demo.MapperTest;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.Dto.ProductDto;
import com.example.demo.Dto.TagDto;
import com.example.demo.Entity.Category;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Tag;
import com.example.demo.Mapper.ProductMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    void convertEntityToDto(){
        List<Tag> tags = new ArrayList<>();
        Category category = new Category();
        Product product = new Product(1L,"phone",120000,"Blue",category, tags);

        ProductDto productDto = productMapper.toDto(product);

        Assertions.assertNotNull(productDto);
        Assertions.assertNotNull(productDto.getId());
        Assertions.assertNotNull(productDto.getName());
        Assertions.assertNotNull(productDto.getPrice());
        Assertions.assertNotNull(productDto.getDescription());
        Assertions.assertNotNull(productDto.getCategory());
        Assertions.assertNotNull(productDto.getTags());

        Assertions.assertEquals(product.getId(),productDto.getId());
        Assertions.assertEquals(product.getName(),productDto.getName());
        Assertions.assertEquals(product.getPrice(),productDto.getPrice());
        Assertions.assertEquals(product.getDescription(),productDto.getDescription());

    }

    @Test
    void convertDtoToEntity(){
        List<TagDto> tagsDto = new ArrayList<>();
        CategoryDto categoryDto = new CategoryDto();
        ProductDto productDto = new ProductDto(1L,"phone",120000,"Blue",categoryDto,tagsDto);

        Product product = productMapper.toEntity(productDto);

        Assertions.assertNotNull(product);
        Assertions.assertNotNull(product.getId());
        Assertions.assertNotNull(product.getName());
        Assertions.assertNotNull(product.getPrice());
        Assertions.assertNotNull(product.getDescription());
        Assertions.assertNotNull(product.getCategory());
        Assertions.assertNotNull(product.getTags());

        Assertions.assertEquals(productDto.getId(),product.getId());
        Assertions.assertEquals(productDto.getName(),product.getName());
        Assertions.assertEquals(productDto.getPrice(),product.getPrice());
        Assertions.assertEquals(productDto.getDescription(),product.getDescription());

    }
    @Test
    void ConvertEntitryListToDtoList(){
        List<Tag> tags = new ArrayList<>();
        Category category = new Category();
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L,"phone",120000,"Blue",category, tags));
        products.add(new Product(2L,"laptop",1800000,"Grey",category, tags));
        products.add(new Product(3L,"Tv",290000,"Black",category, tags));

        List<ProductDto> productDtos = productMapper.toDtoList(products);

        Assertions.assertNotNull(productDtos);
        Assertions.assertNotEquals(0,productDtos.size());
        Assertions.assertEquals(products.size(),productDtos.size());

        for (int i = 0;i<productDtos.size();i++){
            Product product = products.get(i);
            ProductDto productDto = productMapper.toDto(product);

            Assertions.assertNotNull(productDto);
            Assertions.assertNotNull(productDto.getId());
            Assertions.assertNotNull(productDto.getName());
            Assertions.assertNotNull(productDto.getPrice());
            Assertions.assertNotNull(productDto.getDescription());

        }

    }
}
