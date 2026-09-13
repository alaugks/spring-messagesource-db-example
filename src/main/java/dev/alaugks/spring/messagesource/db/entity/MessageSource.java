package dev.alaugks.spring.messagesource.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Locale;

@Entity
@Table(name = "messagesource")
public class MessageSource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "code")
	private String code;

	@Column(name = "value")
	private String value;

	@Column(name = "locale")
	private String locale;

	public long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}

	public Locale getLocale() {
		return Locale.forLanguageTag(locale);
	}
}
