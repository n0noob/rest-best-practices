package com.learn.restbestpractices.services;

public interface QuoteService {

    com.learn.restbestpractices.models.Quote getQuote(Long id);

    Long saveQuote(com.learn.restbestpractices.models.Quote quote);

    Long updateQuote(com.learn.restbestpractices.models.Quote quote);

    boolean removeQuote(Long id);

}
