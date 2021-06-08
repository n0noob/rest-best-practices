package com.learn.restbestpractices.services;

import com.learn.restbestpractices.repositories.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @MockBean
    private AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
    }
}