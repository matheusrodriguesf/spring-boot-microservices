package br.com.pessoal.cambioservice.service;

import java.math.BigDecimal;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.pessoal.cambioservice.api.CambioApi;
import br.com.pessoal.cambioservice.repository.CambioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CambioService {

    private final Environment environment;
    private final CambioRepository repository;

    public CambioApi getCambio(String from, String to, BigDecimal amount) {
        var cambio = repository.findByFromAndTo(from, to);
        if (cambio == null) {
            throw new RuntimeException("Currency not found");
        }
        var port = environment.getProperty("local.server.port");
        return CambioApi.builder()
                .id(cambio.getId())
                .from(cambio.getFrom())
                .to(cambio.getTo())
                .conversionFactor(cambio.getConversionFactor())
                .convertedValue(cambio.getConversionFactor().multiply(amount))
                .environment(port)
                .build();
    }
}
