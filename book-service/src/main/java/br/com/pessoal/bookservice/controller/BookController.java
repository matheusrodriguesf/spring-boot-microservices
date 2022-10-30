package br.com.pessoal.bookservice.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pessoal.bookservice.api.BookApi;
import br.com.pessoal.bookservice.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Book endpoint", description = "Book API")
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    
    private final BookService service;

    @Operation(summary = "Find book by id")
    @GetMapping(value = "/{id}/{currency}")
    public BookApi getBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
        return service.getBook(id, currency);
    }
}
