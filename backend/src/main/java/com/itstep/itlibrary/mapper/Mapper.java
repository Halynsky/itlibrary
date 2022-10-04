package com.itstep.itlibrary.mapper;

import com.itstep.itlibrary.dto.AuthorDto;
import com.itstep.itlibrary.dto.BookDto;
import com.itstep.itlibrary.dto.PublisherInfoDto;
import com.itstep.itlibrary.dto.UserDto;
import com.itstep.itlibrary.entity.Author;
import com.itstep.itlibrary.entity.Book;
import com.itstep.itlibrary.entity.Publisher;
import com.itstep.itlibrary.entity.User;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@org.mapstruct.Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface Mapper {

    UserDto toUserDto(User entity);
    User toUser(UserDto dto);
    @Mapping(target = "password", ignore = true)
    User mergeUser(UserDto dto, @MappingTarget User entity);

    BookDto toBookDto(Book entity);
    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    Book toBook(BookDto dto);
    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    Book mergeBook(BookDto dto, @MappingTarget Book entity);

    AuthorDto toAuthorDto(Author entity);
    Author toAuthor(AuthorDto dto);
    Author mergeAuthor(AuthorDto dto, @MappingTarget Author entity);

    PublisherInfoDto toPublisherInfoDto(Publisher entity);
    Publisher toPublisher(PublisherInfoDto dto);
    Publisher mergePublisher(PublisherInfoDto dto, @MappingTarget Publisher entity);

}
