package com.knet.template.mvc.freemarker.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knet.template.mvc.freemarker.core.vo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("local")
@AutoConfigureMockMvc
public class WebTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Before
	public void before() {

	}

	@After
	public void after() {

	}

	@Test
	public void getUsers() throws Exception {
		this.mockMvc.perform(
			get("/users")
		)
			.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	public void getUser() throws Exception {
		this.mockMvc.perform(
			get("/users/{userId}", "son")
		)
			.andDo(print())
			.andExpect(status().isOk());
	}

}
