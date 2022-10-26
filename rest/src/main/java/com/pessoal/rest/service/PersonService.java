package com.pessoal.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.pessoal.rest.model.Person;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            var person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {
        return Person.builder()
                .id(counter.incrementAndGet())
                .firstName("Matheus")
                .lastName("Rodrigues")
                .address("Brasilia - Distrito Federal - Brasil")
                .build();
    }

    public Person create(Person person) {
        return person;
    }

    public Person update(String id, Person person) {
        return person;
    }

    public void delete(String id) {
    }

    private Person mockPerson(int i) {
        return Person.builder()
                .id(counter.incrementAndGet())
                .firstName("Person Name " + i)
                .lastName("Last Name " + i)
                .address("Some Address in Brasil " + i)
                .build();
    }
}
