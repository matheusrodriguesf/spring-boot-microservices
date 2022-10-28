package br.com.pessoal.cambioservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pessoal.cambioservice.entity.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {
    Cambio findByFromAndTo(String from, String to);
}
