package br.com.pessoal.bookservice.cambio.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.pessoal.bookservice.cambio.api.CambioApi;

@FeignClient(name = "cambio-service", url = "${client.cambio-service.url}")
public interface CambioProxy {

    @GetMapping(value = "/cambio-service/{amount}/{from}/{to}")
    public CambioApi getCambio(
            @PathVariable("amount") Double amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to);

}
