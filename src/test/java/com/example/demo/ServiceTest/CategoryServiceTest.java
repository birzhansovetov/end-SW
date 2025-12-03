package com.example.demo.ServiceTest;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.Entity.Category;
import com.example.demo.Service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    void getAllTest(){
        List<CategoryDto> categoryDtos = categoryService.getAll();

        Assertions.assertNotNull(categoryDtos);
        Assertions.assertNotEquals(0, categoryDtos.size());
        for (int i = 0;i<categoryDtos.size();i++){
            CategoryDto categoryDto = categoryDtos.get(i);
            Assertions.assertNotNull(categoryDto.getId());
            Assertions.assertNotNull(categoryDto.getName());

        }
    }
    @Test
    void getByIdTest(){
        Random random = new Random();
        int RandomIndex = random.nextInt(categoryService.getAll().size());
        Long someId = categoryService.getAll().get(RandomIndex).getId();

        CategoryDto categoryDto = categoryService.getById(someId);

        Assertions.assertNotNull(categoryDto);
        Assertions.assertNotNull(categoryDto.getId());
        Assertions.assertNotNull(categoryDto.getName());

        CategoryDto check = categoryService.getById(-1L);
        Assertions.assertNull(check);


    }
    @Test
    void addCategoryTest(){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("tech");

        CategoryDto createdCategory = categoryService.addCategory(categoryDto);
        Assertions.assertNotNull(createdCategory);
        Assertions.assertNotNull(createdCategory.getId());
        Assertions.assertNotNull(createdCategory.getName());

        Assertions.assertEquals(categoryDto.getName(),createdCategory.getName());
        CategoryDto getCategory = categoryService.getById(createdCategory.getId());

        Assertions.assertNotNull(getCategory);
        Assertions.assertNotNull(getCategory.getId());
        Assertions.assertNotNull(getCategory.getName());
        Assertions.assertEquals(createdCategory.getId(),getCategory.getId());
        Assertions.assertEquals(createdCategory.getName(),getCategory.getName());


    }

    @Test
    void updateCategoryTest(){
        Random random = new Random();
        int RandomIndex = random.nextInt(categoryService.getAll().size());
        Long someId = categoryService.getAll().get(RandomIndex).getId();
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("tets");

        CategoryDto beforeUpdate = categoryService.updateCategory(someId,categoryDto);
        Assertions.assertNotNull(beforeUpdate);
        Assertions.assertNotNull(beforeUpdate.getId());
        Assertions.assertNotNull(beforeUpdate.getName());

        Assertions.assertEquals(categoryDto.getId(),beforeUpdate.getId());
        Assertions.assertEquals(categoryDto.getName(),beforeUpdate.getName());

        CategoryDto afterUpdate = categoryService.getById(someId);
        Assertions.assertNotNull(afterUpdate);
        Assertions.assertNotNull(afterUpdate.getId());
        Assertions.assertNotNull(afterUpdate.getName());

        Assertions.assertEquals(beforeUpdate.getId(),afterUpdate.getId());
        Assertions.assertEquals(beforeUpdate.getName(),afterUpdate.getName());

    }

    @Test
    void deleteCategoryTest(){
        Random random = new Random();
        int RandomIndex = random.nextInt(categoryService.getAll().size());
        Long someId = categoryService.getAll().get(RandomIndex).getId();
        Assertions.assertTrue(categoryService.deleteCategory(someId));
        CategoryDto categoryDto = categoryService.getById(someId);
        Assertions.assertNull(categoryDto);
    }
}
