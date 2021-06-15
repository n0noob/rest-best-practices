package com.learn.restbestpractices.controllers;

import com.learn.restbestpractices.models.Quote;
import com.learn.restbestpractices.services.QuoteService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Quote")
@Slf4j
@RestController
@RequestMapping("/quotes/")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/{id}")
    public Quote getQuote(@PathVariable long id) {
        log.info("Received request for quote id : " + id);
        return quoteService.getQuote(id);
    }

    @PostMapping("/")
    public Long addQuote(@Valid @RequestBody Quote quote) {
        log.info("Received request for adding quote : " + quote.toString());
        return quoteService.saveQuote(quote);
    }

    @PutMapping("/")
    public Long updateQuote(@RequestBody Quote quote) {
        log.info("Received request for updating quote with id : " + quote.getId());
        return quoteService.updateQuote(quote);
    }

    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable long id) {
        log.info("Received request for deleting quote with id : " + id);
        quoteService.deleteQuote(id);
    }

}
