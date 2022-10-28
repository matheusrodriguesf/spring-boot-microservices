package br.com.pessoal.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pessoal.bookservice.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> { }
