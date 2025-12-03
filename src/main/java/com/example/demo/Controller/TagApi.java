package com.example.demo.Controller;

import com.example.demo.Dto.TagDto;
import com.example.demo.Service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/tags")
public class TagApi {
    private final TagService tagService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(tagService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(tagService.getById(id),HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<?> addTag(@RequestBody TagDto tagDto){
        tagService.addTag(tagDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTag(@PathVariable (name = "id") Long id,@RequestBody  TagDto tagDto){
        tagService.updateTag(id,tagDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable (name = "id") Long id){
        return new ResponseEntity<>(tagService.deleteTag(id),HttpStatus.OK);
    }
}
