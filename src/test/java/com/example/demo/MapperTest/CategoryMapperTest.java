package com.example.demo.MapperTest;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.Entity.Category;
import com.example.demo.Mapper.CategoryMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CategoryMapperTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void convertEntityToDto(){
        Category category = new Category(1L,"something");
        CategoryDto categoryDto = categoryMapper.toDto(category);


        Assertions.assertNotNull(categoryDto);
        Assertions.assertNotNull(categoryDto.getId());
        Assertions.assertNotNull(categoryDto.getName());

        Assertions.assertEquals(category.getId(),categoryDto.getId());
        Assertions.assertEquals(category.getName(),categoryDto.getName());
    }

    @Test
    void convertDtoToEntity(){
        CategoryDto categoryDto = new CategoryDto(1L,"something");
        Category category = categoryMapper.toEntity(categoryDto);

        Assertions.assertNotNull(category);
        Assertions.assertNotNull(category.getId());
        Assertions.assertNotNull(category.getName());

        Assertions.assertEquals(categoryDto.getId(),category.getId());
        Assertions.assertEquals(categoryDto.getName(),category.getName());

    }

    @Test
    void ConvertEntitryListToDtoList(){
        List<Category> categories = new ArrayList<>();

        categories.add(new Category(1L,"something"));
        categories.add(new Category(2L,"asdas"));
        categories.add(new Category(3L,"dsffd"));

        List<CategoryDto> categoryDtos = categoryMapper.toDtoList(categories);
        Assertions.assertNotNull(categoryDtos);
        Assertions.assertNotEquals(0,categoryDtos.size());
        Assertions.assertEquals(categories.size(),categoryDtos.size());

        for (int i = 0;i<categoryDtos.size();i++){
            Category category = categories.get(i);
            CategoryDto categoryDto = categoryMapper.toDto(category);

            Assertions.assertNotNull(categoryDto);
            Assertions.assertNotNull(categoryDto.getId());
            Assertions.assertNotNull(categoryDto.getName());

        }

    }
}
