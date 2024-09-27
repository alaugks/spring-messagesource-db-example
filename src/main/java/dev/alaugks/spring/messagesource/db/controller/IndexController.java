package dev.alaugks.spring.messagesource.db.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	private final MessageSource messageSource;

	public IndexController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping(value = "/", name = "index_index")
	public String index(Model model, Locale locale) {
		try {
			model.addAttribute("headline", this.messageSource.getMessage("headline", null, locale));
			model.addAttribute("messages_headline", this.messageSource.getMessage("messages.headline", null, locale));
			model.addAttribute("postcode", this.messageSource.getMessage("postcode", null, locale));
			model.addAttribute("messages_postcode", this.messageSource.getMessage("messages.postcode", null, locale));
			model.addAttribute("payment_headline", this.messageSource.getMessage("payment.headline", null, locale));
			model.addAttribute("payment_expiry_date", this.messageSource.getMessage("payment.expiry_date", null, locale));
		} catch (NoSuchMessageException ignored) {}

		return "index/index";
	}
}
