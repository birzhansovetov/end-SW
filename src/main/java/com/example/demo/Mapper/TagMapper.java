package com.example.demo.Mapper;

import com.example.demo.Dto.TagDto;
import com.example.demo.Entity.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagDto toDto(Tag tag);
    Tag toEntity(TagDto tagDto);
    List<TagDto> toDtoList(List<Tag> tags);
}
