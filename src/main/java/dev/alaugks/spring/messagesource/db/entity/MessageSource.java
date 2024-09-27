package dev.alaugks.spring.messagesource.db.entity;

import java.util.Locale;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

	@Column(name = "domain")
	private String domain;

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

	public String getDomain() {
		return domain;
	}
}
