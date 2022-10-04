package com.itstep.itlibrary.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class PublisherInfoDto {
    private Long id;
    private String name;
    private ZonedDateTime founded;
}
