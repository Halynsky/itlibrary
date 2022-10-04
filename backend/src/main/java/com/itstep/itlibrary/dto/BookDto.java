package com.itstep.itlibrary.dto;

import com.itstep.itlibrary.enums.InventoryStatus;
import lombok.Data;

import java.util.Set;

@Data
public class BookDto {
    private Long id;
    private String title;
    private Integer price;
    private InventoryStatus inventoryStatus;
    private Double rating;
    private Set<AuthorDto> authors;
    private PublisherInfoDto publisher;
}
