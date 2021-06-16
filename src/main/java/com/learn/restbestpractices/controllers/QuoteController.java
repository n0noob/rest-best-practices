package com.learn.restbestpractices.controllers;

import com.learn.restbestpractices.models.Quote;
import com.learn.restbestpractices.services.QuoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Quote")
@Slf4j
@RestController
@RequestMapping("rest_best_practices/v1/quotes/")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @ApiOperation("Get quote details for a given quote id")
    @GetMapping("/{id}")
    public Quote getQuote(@PathVariable long id) {
        log.info("Received request for quote id : " + id);
        return quoteService.getQuote(id);
    }

    @ApiOperation("Register a new quote")
    @PostMapping("/")
    public Long addQuote(@Valid @RequestBody Quote quote) {
        log.info("Received request for adding quote : " + quote.toString());
        return quoteService.saveQuote(quote);
    }

    @ApiOperation("Update quote corresponding to a given quote id")
    @PutMapping("/")
    public Long updateQuote(@Valid @RequestBody Quote quote) {
        log.info("Received request for updating quote with id : " + quote.getId());
        return quoteService.updateQuote(quote);
    }

    @ApiOperation("Delete quote details for a given quote id")
    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable long id) {
        log.info("Received request for deleting quote with id : " + id);
        quoteService.deleteQuote(id);
    }

}
