package com.learn.restbestpractices.controllers;

import com.learn.restbestpractices.services.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/quotes/v1/")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;
    
}
