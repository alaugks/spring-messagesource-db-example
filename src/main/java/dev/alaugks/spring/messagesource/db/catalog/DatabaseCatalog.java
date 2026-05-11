package dev.alaugks.spring.messagesource.db.catalog;

import dev.alaugks.spring.messagesource.db.repository.MessageSourceRepository;
import io.github.alaugks.spring.messagesource.catalog.catalog.AbstractCatalog;
import io.github.alaugks.spring.messagesource.catalog.records.TransUnit;
import io.github.alaugks.spring.messagesource.catalog.records.TransUnitInterface;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DatabaseCatalog extends AbstractCatalog {

	private final MessageSourceRepository messageSourceRepository;

	public DatabaseCatalog(MessageSourceRepository messageSourceRepository) {
		this.messageSourceRepository = messageSourceRepository;
	}

	@Override
	public List<TransUnitInterface> getTransUnits() {
		List<TransUnitInterface> transUnits = new ArrayList<>();
		this.messageSourceRepository.findAll().forEach(tu -> transUnits.add(new TransUnit(
			tu.getLocale(),
			tu.getCode(),
			tu.getValue(),
			tu.getDomain()
		)));
		return transUnits;
	}
}
