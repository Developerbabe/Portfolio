package tech.portfolo.portfolo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PortfoloApplication extends ServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PortfoloApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PortfoloApplication.class);
	}
}
