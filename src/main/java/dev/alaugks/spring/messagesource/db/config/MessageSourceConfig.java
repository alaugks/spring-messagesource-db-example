package dev.alaugks.spring.messagesource.db.config;


import dev.alaugks.spring.messagesource.db.repository.MessageSourceRepository;
import io.github.alaugks.spring.messagesource.base.BaseMessageSourceBuilder;
import io.github.alaugks.spring.messagesource.base.records.TransUnit;
import io.github.alaugks.spring.messagesource.base.records.TransUnitInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageSourceConfig {

	private final MessageSourceRepository messageSourceRepository;

	public MessageSourceConfig(MessageSourceRepository messageSourceRepository) {
		this.messageSourceRepository = messageSourceRepository;
	}

	@Bean
	public MessageSource messageSource(List<TransUnitInterface> transUnits) {
		return BaseMessageSourceBuilder
				.builder(Locale.forLanguageTag("en"), transUnits)
				.build();
	}

	@Bean
	public List<TransUnitInterface> transUnits() {
		List<TransUnitInterface> transUnits = new ArrayList<>();
		this.messageSourceRepository.findAll().forEach(tu -> transUnits.add(new TransUnit(
			tu.getLocale(),
			tu.getCode(),
			tu.getValue()
		)));
		return transUnits;
	}
}
