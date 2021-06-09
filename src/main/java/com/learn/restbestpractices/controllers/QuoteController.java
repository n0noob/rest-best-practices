package com.learn.restbestpractices.controllers;

import com.learn.restbestpractices.models.Quote;
import com.learn.restbestpractices.services.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/quotes/")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping(value = "/{id}")
    public Quote getQuote(@PathVariable long id) {
        log.info("Received request for quote id : " + id);
        return quoteService.getQuote(id);
    }

}
