package com.example.demo.Dto;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.Tag;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private Long id;
    private String name;
    private int price;
    private String description;
    private Category category;
    private List<Tag> tags;


}
