package com.triplexng.taskmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("text-summary")
public class summarizer {
    @GetMapping(value = "/{id}", produces = "application/json")
    public String getBook(@PathVariable String id) {
        return id;
    }

}
