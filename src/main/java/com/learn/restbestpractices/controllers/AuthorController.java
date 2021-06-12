package com.learn.restbestpractices.controllers;

import com.learn.restbestpractices.models.Author;
import com.learn.restbestpractices.services.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/authors/")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable long id) {
        log.info("Received request for author id : " + id);
        return authorService.getAuthor(id);
    }

    @PostMapping("/")
    public Long addAuthor(@RequestBody Author author) {
        log.info("Received request for adding author : " + author.toString());
        return authorService.saveAuthor(author);
    }

    @PutMapping("/")
    public Long updateAuthor(@RequestBody Author author) {
        log.info("Received request for updating author with id : " + author.getId());
        return authorService.updateAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable long id) {
        log.info("Received request for deleting author with id : " + id);
        authorService.deleteAuthor(id);
    }

}
