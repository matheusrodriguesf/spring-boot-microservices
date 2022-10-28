package br.com.pessoal.bookservice.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pessoal.bookservice.api.BookApi;
import br.com.pessoal.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping(value = "/{id}/{currency}")
    public BookApi getBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
        return service.getBook(id, currency);
    }
}
