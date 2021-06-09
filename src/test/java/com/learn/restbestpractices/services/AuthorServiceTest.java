package com.learn.restbestpractices.services;

import com.learn.restbestpractices.entities.Author;
import com.learn.restbestpractices.repositories.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @MockBean
    private AuthorRepository authorRepository;

    private Author savedAuthorEntity;

    @BeforeEach
    void setUp() {
        savedAuthorEntity = Author.builder()
                .id(15L)
                .fullName("Mahatma Gandhi")
                .dob(LocalDateTime.now())
                .bioLink("https://en.wikipedia.org/wiki/Mahatma_Gandhi")
                .build();

        Mockito.when(authorRepository.findById(savedAuthorEntity.getId()))
                .thenReturn(Optional.of(savedAuthorEntity));
    }

    private Author getAuthorEntityCharlesBukowski() {
        return Author.builder()
                .fullName("Charles Bukowski")
                .dob(LocalDateTime.now())
                .bioLink("https://en.wikipedia.org/wiki/Charles_Bukowski")
                .build();
    }

    private com.learn.restbestpractices.models.Author getAuthorModelCharlesBukowski() {
        return com.learn.restbestpractices.models.Author.builder()
                .fullName("Charles Bukowski")
                .dob(LocalDateTime.now())
                .bioLink("https://en.wikipedia.org/wiki/Charles_Bukowski")
                .build();
    }

    private com.learn.restbestpractices.models.Author getAuthorModelMahatmaGandhi() {
        return com.learn.restbestpractices.models.Author.builder()
                .id(15L)
                .fullName("Mahatma Gandhi")
                .dob(LocalDateTime.now())
                .bioLink("https://en.wikipedia.org/wiki/Mahatma_Gandhi")
                .build();
    }

    @Test
    public void whenAuthorIsPresent_thenGetAuthorSucceeds() {
        authorService.getAuthor(savedAuthorEntity.getId());
    }

    @Test
    public void whenAuthorIsNotPresent_thenGetAuthorFails() {
        NoSuchElementException noSuchElementException = assertThrows(NoSuchElementException.class, () -> {
            authorService.getAuthor(16L);
        });
        assertTrue(noSuchElementException.getMessage().contains("No value present"));
    }

    @Test
    public void whenAuthorIsToBeSaved_thenSaveAuthorSucceeds() {
        //When
        Author authorEntity = getAuthorEntityCharlesBukowski();
        Mockito.when(authorRepository.save(any())).thenReturn(authorEntity);
        //Then
        authorService.saveAuthor(getAuthorModelCharlesBukowski());
        Mockito.verify(authorRepository).save(any());
    }

    @Test
    public void whenAuthorIsPresent_thenUpdateAuthorSucceeds() {
        //When
        com.learn.restbestpractices.models.Author authorModel = getAuthorModelMahatmaGandhi();
        Mockito.when(authorRepository.save(any())).thenReturn(savedAuthorEntity);
        //Then
        authorService.updateAuthor(getAuthorModelMahatmaGandhi());
        Mockito.verify(authorRepository).findById(any());
        Mockito.verify(authorRepository).save(any());
    }

    @Test
    public void whenAuthorIsPresent_thenDeleteAuthor() {
        //When
        Long savedAuthorId = savedAuthorEntity.getId();
        //Then
        authorService.deleteAuthor(savedAuthorId);
        Mockito.verify(authorRepository).deleteById(any());
    }
}