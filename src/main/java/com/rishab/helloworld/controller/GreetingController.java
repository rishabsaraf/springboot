package com.rishab.helloworld.controller;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rishab.helloworld.exception.GreetingNotFoundException;
import com.rishab.helloworld.pojo.Greeting;
import com.rishab.helloworld.repository.GreetingRepository;

@RestController
public class GreetingController {

    public static final String template = "Hello, %s!";
    private final AtomicInteger counter = new AtomicInteger();
    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingController(final GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @RequestMapping(path = "/greeting", method = RequestMethod.POST)
    public Greeting greeting(@RequestParam(name = "name", required = true) final String name) {
        Greeting greeting = new Greeting(String.format(template, name));
        greetingRepository.save(greeting);
        return greeting;
    }

    @RequestMapping(path = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(name = "id", required = true) final long id) {
        return greetingRepository.findById(id)
                                 .orElseThrow(new Supplier<GreetingNotFoundException>() {
                                     @Override
                                     public GreetingNotFoundException get() {
                                         return new GreetingNotFoundException(id);
                                     }
                                 });
    }
}
