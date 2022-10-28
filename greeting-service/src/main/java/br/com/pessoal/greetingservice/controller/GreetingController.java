package br.com.pessoal.greetingservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pessoal.greetingservice.configuration.GreetingConfiguration;
import br.com.pessoal.greetingservice.model.Greeting;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private static final String TEMPLATE = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final GreetingConfiguration configuration;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
        if (name.isBlank()) {
            name = configuration.getDefaultValue();
        }
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, configuration.getGreeting(), name));
    }
}
