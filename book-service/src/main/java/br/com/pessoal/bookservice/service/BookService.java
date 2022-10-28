package br.com.pessoal.bookservice.service;

import java.time.LocalDate;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.pessoal.bookservice.api.BookApi;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    
    private final Environment environment;

    public BookApi getBook(Long id, String currency) {
        return BookApi.builder()
                .id(id)
                .author("Autor")
                .currency(currency)
                .environment(environment.getProperty("local.server.port"))
                .launchDate(LocalDate.now())
                .price(100.0)
                .title("Título")
                .build();
    }
}
