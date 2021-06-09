package com.learn.restbestpractices.services.impl;

import com.learn.restbestpractices.entities.Author;
import com.learn.restbestpractices.entities.Quote;
import com.learn.restbestpractices.repositories.AuthorRepository;
import com.learn.restbestpractices.repositories.QuoteRepository;
import com.learn.restbestpractices.services.QuoteService;
import com.learn.restbestpractices.services.mappers.QuoteMapper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private AuthorRepository authorRepository;

    private QuoteMapper quoteMapper = Mappers.getMapper(QuoteMapper.class);

    @Override
    public com.learn.restbestpractices.models.Quote getQuote(Long id) {
        return quoteMapper.map(
                quoteRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public Long saveQuote(com.learn.restbestpractices.models.Quote quote) {
        Quote quoteEntity = quoteMapper.map(quote);

        //Map authorId to author
        Author author = authorRepository.findById(quote.getId()).orElseThrow();
        quoteEntity.setAuthor(author);

        return quoteRepository.save(quoteEntity).getId();
    }

    @Override
    public Long updateQuote(com.learn.restbestpractices.models.Quote quote) {
        quoteRepository.findById(quote.getId()).orElseThrow();

        Quote quoteEntity = quoteMapper.map(quote);

        //Map authorId to author
        Author author = authorRepository.findById(quote.getId()).orElseThrow();
        quoteEntity.setAuthor(author);

        return quoteRepository.save(quoteEntity).getId();
    }

    @Override
    public boolean deleteQuote(Long id) {
        quoteRepository.deleteById(id);
        return true;
    }
}
