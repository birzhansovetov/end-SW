package com.example.demo.Service;

import com.example.demo.Dto.TagDto;
import com.example.demo.Entity.Tag;
import com.example.demo.Mapper.TagMapper;
import com.example.demo.Repository.TagRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepo tagRepo;
    private  final TagMapper tagMapper;

    public List<TagDto> getAll(){
        List<Tag> tags = tagRepo.findAll();
        return tagMapper.toDtoList(tags);
    }

    public TagDto getById(Long id){
        return tagMapper.toDto(tagRepo.findById(id).orElse(null));
    }

    public void addTag(TagDto tagDto){
        tagRepo.save(tagMapper.toEntity(tagDto));
    }

    public void updateTag(Long id,TagDto tagDto){
        Tag tag = tagRepo.findById(id).orElse(null);
        tag = Tag.builder()
                .name(tagDto.getName())
                .products(tagDto.getProducts())
                .build();
        tagRepo.save(tag);
    }
    public boolean deleteTag(Long id){
        Tag tag = tagRepo.findById(id).orElse(null);
        if (Objects.isNull(tag)){
            return false;
        }
        tagRepo.deleteById(id);
        return true;
    }
}
