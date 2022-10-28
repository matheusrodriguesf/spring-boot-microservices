package br.com.pessoal.greetingservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@ConfigurationProperties("greeting-service")
@NoArgsConstructor
@Getter
@Setter
public class GreetingConfiguration {
    private String greeting;
    private String defaultValue;
}