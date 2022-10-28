package br.com.pessoal.cambioservice.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pessoal.cambioservice.api.CambioApi;
import br.com.pessoal.cambioservice.service.CambioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("cambio-service")
@RequiredArgsConstructor
public class CambioController {

    private final CambioService service;

    @GetMapping(value = "/{amount}/{from}/{to}")
    public CambioApi getCambio(
            @PathVariable("amount") BigDecimal amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to) {
        return service.getCambio(from, to, amount);
    }
}
