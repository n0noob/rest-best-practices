package com.learn.restbestpractices.repositories;

import com.learn.restbestpractices.entities.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertSame;


import java.time.LocalDateTime;
import java.util.Date;

@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void givenAuthor_whenAuthorNotPresentInDB_thenAuthorGetsSaved() {
        //when
        String authorName = "Mahatma Gandhi";
        Author author = Author.builder()
                .fullName(authorName)
                .dob(LocalDateTime.now())
                .bioLink("https://en.wikipedia.org/wiki/Mahatma_Gandhi")
                .build();

        Long id = authorRepository.save(author).getId();

        //then
        assertSame(authorRepository.findById(id).orElseThrow().getFullName(), authorName);
    }

}
