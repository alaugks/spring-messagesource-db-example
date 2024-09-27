package dev.alaugks.spring.messagesource.db.config;


import java.util.Locale;

import dev.alaugks.spring.messagesource.db.catalog.DatabaseCatalog;
import io.github.alaugks.spring.messagesource.catalog.CatalogMessageSourceBuilder;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageSourceConfig {

	private final DatabaseCatalog databaseCatalog;

	public MessageSourceConfig(DatabaseCatalog databaseCatalog) {
		this.databaseCatalog = databaseCatalog;
	}

	@Bean
	public MessageSource messageSource() {
		return CatalogMessageSourceBuilder
				.builder(this.databaseCatalog, Locale.forLanguageTag("en"))
				.build();
	}

}
