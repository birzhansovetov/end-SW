package com.example.demo.MapperTest;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.Dto.TagDto;
import com.example.demo.Entity.Category;
import com.example.demo.Entity.Tag;
import com.example.demo.Mapper.TagMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TagMapperTest {
    @Autowired
    private TagMapper tagMapper;

    @Test
    void convertEntityToDto(){
        Tag tag = new Tag(1L,"name");
        TagDto tagDto = tagMapper.toDto(tag);

        Assertions.assertNotNull(tagDto);
        Assertions.assertNotNull(tagDto.getId());
        Assertions.assertNotNull(tagDto.getName());

        Assertions.assertEquals(tag.getId(),tagDto.getId());
        Assertions.assertEquals(tag.getName(),tagDto.getName());

    }

    @Test
    void convertDtoToEntity(){
        TagDto tagDto = new TagDto(1L,"name");
        Tag tag = tagMapper.toEntity(tagDto);

        Assertions.assertNotNull(tag);
        Assertions.assertNotNull(tag.getId());
        Assertions.assertNotNull(tag.getName());

        Assertions.assertEquals(tagDto.getId(),tag.getId());
        Assertions.assertEquals(tagDto.getName(),tag.getName());

    }
    @Test
    void ConvertEntitryListToDtoList(){
        List<Tag> tags = new ArrayList<>();

        tags.add(new Tag(1L,"something")));
        tags.add(new Tag(2L,"asdas"));
        tags.add(new Tag(3L,"dsffd"));

        List<TagDto> tagDtos = tagMapper.toDtoList(tags);
        Assertions.assertNotNull(tagDtos);
        Assertions.assertNotEquals(0,tagDtos.size());
        Assertions.assertEquals(tags.size(),tagDtos.size());

        for (int i = 0;i<tagDtos.size();i++){
            Tag tag = tags.get(i);
            TagDto tagDto = tagMapper.toDto(tag);

            Assertions.assertNotNull(tagDto);
            Assertions.assertNotNull(tagDto.getId());
            Assertions.assertNotNull(tagDto.getName());

        }

    }
    }
}
