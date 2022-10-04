package com.itstep.itlibrary.dto;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class PublisherDto {
    private Long id;
    private String name;
    private List<BookDto> books;
    private ZonedDateTime founded;
}
