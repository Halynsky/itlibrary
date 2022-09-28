package com.itstep.itlibrary.mapper;

import com.itstep.itlibrary.dto.UserDto;
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

}
