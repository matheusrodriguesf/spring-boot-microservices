package com.pessoal.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pessoal.rest.model.Person;
import com.pessoal.rest.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Person findById(String id) {
        return personService.findById(id);
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }


    @PutMapping("/{id}")
    public Person update(@PathVariable String id, @RequestBody Person person) {
        return personService.update(id,person);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        personService.delete(id);
    }
}
