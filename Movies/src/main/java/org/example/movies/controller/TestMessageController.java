package org.example.movies.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.movies.ProducerService;
import org.example.movies.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class TestMessageController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/send")
    public String sendEntity(@RequestBody Country entity) throws JsonProcessingException {
        System.out.println("called producer service");
        producerService.sendEntity(entity);

        return "entity sent";
    }

    @GetMapping("/test")
    public String sendTest() {
        System.out.println("called producer service");
        producerService.sendTest();

        return "test sent";
    }
}
