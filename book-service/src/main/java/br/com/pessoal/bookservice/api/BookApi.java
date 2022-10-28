package br.com.pessoal.bookservice.api;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookApi implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String author;
    private LocalDate launchDate;
    private Double price;
    private String title;
    private String currency;
    private String environment;
}