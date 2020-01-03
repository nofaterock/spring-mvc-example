package com.nofaterock.mvc.api.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nofaterock.mvc.api.core.vo.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("local")
@AutoConfigureMockMvc
public class ApiTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void addUsers() throws Exception {
		User user = new User("cha", "차범근");

		this.mockMvc.perform(
			post("/api/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user))
		)
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is(user.getName())));
	}

	@Test
	public void updateUsers() throws Exception {
		User user = new User("park", "박지성2");

		this.mockMvc.perform(
			put("/api/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user))
		)
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is(user.getName())));
	}

	@Test
	public void deleteUsers() throws Exception {
		this.mockMvc.perform(
			delete("/api/users/{userId}", "lee")
		)
			.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	public void getUsers() throws Exception {
		this.mockMvc.perform(
			get("/api/users/{userId}", "son")
		)
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is("손흥민")));
	}

}
