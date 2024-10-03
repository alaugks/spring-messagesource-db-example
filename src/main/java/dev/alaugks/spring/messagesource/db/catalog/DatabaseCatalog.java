package dev.alaugks.spring.messagesource.db.catalog;

import java.util.ArrayList;
import java.util.List;

import dev.alaugks.spring.messagesource.db.repository.MessageSourceRepository;
import io.github.alaugks.spring.messagesource.catalog.catalog.AbstractCatalog;
import io.github.alaugks.spring.messagesource.catalog.records.TransUnit;
import io.github.alaugks.spring.messagesource.catalog.records.TransUnitInterface;

import org.springframework.stereotype.Component;

@Component
public class DatabaseCatalog extends AbstractCatalog {

	private final MessageSourceRepository messageSourceRepository;

	private final List<TransUnitInterface> transUnits = new ArrayList<>();

	public DatabaseCatalog(MessageSourceRepository messageSourceRepository) {
		this.messageSourceRepository = messageSourceRepository;
	}

	@Override
	public List<TransUnitInterface> getTransUnits() {
		return this.transUnits;
	}

	@Override
	public void build() {
		this.messageSourceRepository.findAll().forEach(c -> this.transUnits.add(new TransUnit(
				c.getLocale(),
				c.getCode(),
				c.getValue(),
				c.getDomain()
		)));
	}
}
