package com.learn.restbestpractices;

import com.learn.restbestpractices.entities.Author;
import com.learn.restbestpractices.entities.Quote;
import com.learn.restbestpractices.repositories.AuthorRepository;
import com.learn.restbestpractices.repositories.QuoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class StartupProcessor implements CommandLineRunner {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        //testAuthorRepository();
        //testQuoteRepository();
        List<Author> authorList = authorRepository.findAll();
        authorList.forEach(author -> log.info("List item -> " + author.toString()));
    }

    private Long testAuthorRepository() {
        Author author = Author.builder()
                .fullName("Mahatma Gandhi")
                .dob(LocalDateTime.now())
                .bioLink("https://en.wikipedia.org/wiki/Mahatma_Gandhi")
                .build();

        Author persistedAuthor = authorRepository.save(author);
        log.info("persistedAuthor : " + persistedAuthor );

        return persistedAuthor.getId();
    }

    public Long testQuoteRepository() {
        Long authorId = 1L;

        Author author = authorRepository.findById(authorId).orElseThrow();

        Quote quote = Quote.builder()
                .quoteText("An eye for eye only ends up making the whole world blind.")
                .author(author)
                .build();

        Quote persistedQuote = quoteRepository.save(quote);
        log.info("persistedQuote : " + persistedQuote);

        return persistedQuote.getId();
    }

}
