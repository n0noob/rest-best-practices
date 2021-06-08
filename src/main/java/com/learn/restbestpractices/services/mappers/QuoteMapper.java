package com.learn.restbestpractices.services.mappers;

import com.learn.restbestpractices.entities.Quote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface QuoteMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "author", ignore = true)
    Quote map(com.learn.restbestpractices.models.Quote quote);

    @Mapping(target = "authorId", source = "author.id")
    com.learn.restbestpractices.models.Quote map(Quote quote);
    
}
