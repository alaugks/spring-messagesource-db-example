package dev.alaugks.spring.messagesource.db;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class IndexControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void test_index() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(MockMvcResultMatchers.redirectedUrl("/en/home"))
				.andExpect(MockMvcResultMatchers.status().is3xxRedirection())
				.andReturn();
	}

	static Stream<Arguments> translationsProvider() {
		return Stream.of(
				Arguments.of(
						"/en/home",
						List.of(
								"Headline", "Postcode", "Payment", "Expire",
								"Mx.", "You deleted 1,000 files.", "Open the app on your phone.",
								"How is she?", "Your card expires on July 31, 2026."
						)
				),
				Arguments.of(
						"/en-us/home",
						List.of(
								"Headline", "Zip code", "Payment", "Expiration date",
								"Mx.", "You deleted 1,000 files.", "Open the app on your phone.",
								"How is she?", "Your card expires on July 31, 2026."
						)
				),
				Arguments.of(
						"/de/home",
						List.of(
								"Überschrift", "Postleitzahl", "Zahlung", "Ablaufdatum",
								"Divers", "Sie haben 1.000 Dateien gelöscht.", "Öffnen Sie die App auf Ihrem Smartphone.",
								"Wie geht&#39;s ihr?", "Ihre Karte läuft am 31. Juli 2026 ab."
						)
				)
		);
	}

	@ParameterizedTest(name = "{0} renders {1}")
	@MethodSource("translationsProvider")
	void test_home_rendersTranslations(String path, List<String> translations) throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get(path))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		String content = result.getResponse().getContentAsString();

		for (String translation : translations) {
			long count = Pattern.compile(Pattern.quote(translation)).matcher(content).results().count();
			assertThat(count)
					.as("translation = %s, expected >= 2", translation)
					.isGreaterThanOrEqualTo(2);
		}
	}

	@Test
	void test_home_languageMenu() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/de/home"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		assertThat(result.getResponse().getContentAsString())
				.contains("href=\"/en/home\"")
				.contains("href=\"/de/home\"")
				.contains("href=\"/en-us/home\"");
	}
}
