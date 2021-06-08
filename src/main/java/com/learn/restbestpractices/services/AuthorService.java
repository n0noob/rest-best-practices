package com.learn.restbestpractices.services;

public interface AuthorService {

    com.learn.restbestpractices.models.Author getAuthor(Long id);

    Long saveAuthor(com.learn.restbestpractices.models.Author author);

    Long updateAuthor(com.learn.restbestpractices.models.Author author);

    boolean removeAuthor(Long id);

}
