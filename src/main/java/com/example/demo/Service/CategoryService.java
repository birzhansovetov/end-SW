package com.example.demo.Service;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.Entity.Category;
import com.example.demo.Mapper.CategoryMapper;
import com.example.demo.Repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> getAll(){
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDto> categoryDtos = categoryMapper.toDtoList(categories);
        return categoryDtos;
    }

    public CategoryDto getById(Long id){
        return categoryMapper.toDto(categoryRepo.findById(id).orElse(null));
    }

    public CategoryDto addCategory(CategoryDto categoryDto) {

        return categoryMapper.toDto(categoryRepo.save(categoryMapper.toEntity(categoryDto)));
    }
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto){
        Category update = categoryRepo.findById(id).orElse(null);
        update = Category
                .builder()
                .name(categoryDto.getName())
                .build();

        return categoryMapper.toDto(categoryRepo.save(update));
    }

    public boolean deleteCategory(Long id){
        Category category = categoryRepo.findById(id).orElse(null);
        if(Objects.isNull(category)){
            return false;
        }
        categoryRepo.deleteById(id);
        return true;

    }
}
