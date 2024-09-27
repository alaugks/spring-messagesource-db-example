package dev.alaugks.spring.messagesource.db;

import dev.alaugks.spring.messagesource.db.config.WebMvcConfigurerConfig;
import dev.alaugks.spring.messagesource.db.controller.IndexController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;


@WebMvcTest({IndexController.class})
@Import({IndexController.class})
@ContextConfiguration(classes = {
		TestMessageSourceConfig.class,
		WebMvcConfigurerConfig.class
})
class IndexControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void test_home_localeEn() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/?lang=en"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		assertThat(result.getResponse().getContentAsString().indexOf("Postcode")).isPositive();
	}

	@Test
	void test_home_localeDe() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/?lang=de"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		assertThat(result.getResponse().getContentAsString().indexOf("Postleitzahl")).isPositive();
	}

	@Test
	void test_home_localeEnUs() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/?lang=en-us"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		assertThat(result.getResponse().getContentAsString().indexOf("Zip code")).isPositive();
	}
}

