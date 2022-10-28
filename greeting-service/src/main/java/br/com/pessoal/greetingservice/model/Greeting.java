package br.com.pessoal.greetingservice.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Greeting implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String content;
}
