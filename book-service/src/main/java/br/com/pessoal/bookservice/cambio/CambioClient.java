package br.com.pessoal.bookservice.cambio;

import org.springframework.stereotype.Service;

import br.com.pessoal.bookservice.cambio.client.CambioProxy;

@Service
public record CambioClient(CambioProxy cambioProxy) { }
