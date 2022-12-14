package br.com.pessoal.bookservice.service;

import java.time.LocalDate;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.pessoal.bookservice.api.BookApi;
import br.com.pessoal.bookservice.cambio.CambioClient;
import br.com.pessoal.bookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final Environment environment;
    private final BookRepository repository;
    private final CambioClient cambioClient;

    public BookApi getBook(Long id, String currency) {
        var book = repository.findById(id);
        if (!book.isPresent()) {
            throw new RuntimeException("Book not found");
        }
        var port = environment.getProperty("local.server.port");
        var cambio = cambioClient.cambioProxy().getCambio(book.get().getPrice(), "USD", currency);
        return BookApi.builder()
                .id(book.get().getId())
                .author(book.get().getAuthor())
                .launchDate(book.get().getLaunchDate())
                .price(cambio.getConvertedValue())
                .title(book.get().getTitle())
                .currency(currency)
                .environment(cambio.getEnvironment() + " from port: " + port)
                .build();
    }
}
