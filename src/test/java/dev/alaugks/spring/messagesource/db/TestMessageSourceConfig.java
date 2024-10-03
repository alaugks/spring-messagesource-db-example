package dev.alaugks.spring.messagesource.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.github.alaugks.spring.messagesource.catalog.CatalogMessageSourceBuilder;
import io.github.alaugks.spring.messagesource.catalog.records.TransUnit;
import io.github.alaugks.spring.messagesource.catalog.records.TransUnitInterface;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestMessageSourceConfig {
	@Bean
	public MessageSource messageSource() {
		List<TransUnitInterface> transUnits = new ArrayList<>() {{
			add(new TransUnit(Locale.forLanguageTag("en"), "postcode", "Postcode"));
			add(new TransUnit(Locale.forLanguageTag("de"), "postcode", "Postleitzahl"));
			add(new TransUnit(Locale.forLanguageTag("en-US"), "postcode", "Zip code"));
		}};

		return CatalogMessageSourceBuilder
				.builder(transUnits, Locale.forLanguageTag("en"))
				.build();
	}
}
