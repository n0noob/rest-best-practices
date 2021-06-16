package com.learn.restbestpractices.controllers;

import com.learn.restbestpractices.models.Author;
import com.learn.restbestpractices.services.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Author")
@Slf4j
@RestController
@RequestMapping("rest_best_practices/v1/authors/")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @ApiOperation("Get author details for a given author id")
    @GetMapping("/{id}")
    public Author getAuthor(@ApiParam("Author Id") @PathVariable long id) {
        log.info("Received request for author id : " + id);
        return authorService.getAuthor(id);
    }

    @ApiOperation("Register a new author")
    @PostMapping("/")
    public Long addAuthor(@Valid @RequestBody Author author) {
        log.info("Received request for adding author : " + author.toString());
        return authorService.saveAuthor(author);
    }

    @ApiOperation("Update author corresponding to a given author id")
    @PutMapping("/")
    public Long updateAuthor(@Valid @RequestBody Author author) {
        log.info("Received request for updating author with id : " + author.getId());
        return authorService.updateAuthor(author);
    }

    @ApiOperation("Delete author details for a given author id")
    @DeleteMapping("/{id}")
    public void deleteAuthor(@ApiParam("Author Id") @PathVariable long id) {
        log.info("Received request for deleting author with id : " + id);
        authorService.deleteAuthor(id);
    }

}
