package com.learn.restbestpractices.services.mappers;

import com.learn.restbestpractices.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AuthorMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Author map(com.learn.restbestpractices.models.Author author);

    com.learn.restbestpractices.models.Author map(Author author);

}
