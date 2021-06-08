package com.learn.restbestpractices.repositories;

import com.learn.restbestpractices.entities.Author;
import com.learn.restbestpractices.entities.Quote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class QuoteRepositoryTest {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void givenQuote_whenAuthorIsNotPresentInDB_thenExceptionIsThrown() {

        //given
        Long authorId = 15L;

        //when
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            Author author = authorRepository.findById(authorId).orElseThrow();
        });

        //then
        String expectedMessage = "No value present";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

}
