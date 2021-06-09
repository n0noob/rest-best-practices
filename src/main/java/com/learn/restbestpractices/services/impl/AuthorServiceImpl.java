package com.learn.restbestpractices.services.impl;

import com.learn.restbestpractices.entities.Author;
import com.learn.restbestpractices.repositories.AuthorRepository;
import com.learn.restbestpractices.services.AuthorService;
import com.learn.restbestpractices.services.mappers.AuthorMapper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    private AuthorMapper authorMapper = Mappers.getMapper(AuthorMapper.class);

    @Override
    public com.learn.restbestpractices.models.Author getAuthor(Long id) {
        return authorMapper.map(
                authorRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public Long saveAuthor(com.learn.restbestpractices.models.Author author) {
        Author authorEntity = authorMapper.map(author);
        return authorRepository.save(authorEntity).getId();
    }

    @Override
    public Long updateAuthor(com.learn.restbestpractices.models.Author author) {
        authorRepository.findById(author.getId()).orElseThrow();

        Author authorEntity = authorMapper.map(author);
        return authorRepository.save(authorEntity).getId();
    }

    @Override
    public boolean deleteAuthor(Long id) {
        authorRepository.deleteById(id);
        return true;
    }

}
