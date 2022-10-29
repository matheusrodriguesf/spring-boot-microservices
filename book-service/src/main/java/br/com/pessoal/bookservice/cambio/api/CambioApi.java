package br.com.pessoal.bookservice.cambio.api;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CambioApi implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String from;
    private String to;
    private Double conversionFactor;
    private Double convertedValue;
    private String environment;
}