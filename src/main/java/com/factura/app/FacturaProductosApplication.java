package com.factura.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FacturaProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturaProductosApplication.class, args);
	}

}
