package dev.alaugks.spring.messagesource.db;

import io.github.alaugks.spring.messagesource.base.BaseMessageSourceBuilder;
import io.github.alaugks.spring.messagesource.base.records.TransUnit;
import io.github.alaugks.spring.messagesource.base.records.TransUnitInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



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

		return BaseMessageSourceBuilder
				.builder(Locale.forLanguageTag("en"), transUnits)
				.build();
	}
}
