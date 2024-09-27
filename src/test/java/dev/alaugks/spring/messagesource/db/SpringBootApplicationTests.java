package dev.alaugks.spring.messagesource.db;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringBootApplicationTests {

    @Autowired
    private MessageSource messageSource;

    @Test
    void test_MessageSourceBean() {
        assertEquals("Postcode", this.messageSource.getMessage("postcode", null, Locale.forLanguageTag("en")));
        assertEquals("Postleitzahl", this.messageSource.getMessage("postcode", null, Locale.forLanguageTag("de")));
        assertEquals("Zip code", this.messageSource.getMessage("postcode", null, Locale.forLanguageTag("en-US")));
    }

}
