package com.example.demo.Controller;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categories")
@RequiredArgsConstructor
public class CategoryApi {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getByID(@PathVariable(name="id") Long id){
        return new ResponseEntity<>(categoryService.getById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto){
        categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable(name = "id") Long id,
                                            @RequestBody CategoryDto categoryDto){
        categoryService.updateCategory(id,categoryDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable (name = "id") Long id){
        return new ResponseEntity<>(categoryService.deleteCategory(id),HttpStatus.OK);
    }

}
