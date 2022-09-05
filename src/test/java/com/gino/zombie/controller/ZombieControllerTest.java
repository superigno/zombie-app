package com.gino.zombie.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gino.zombie.constant.ZombieConstants;
import com.gino.zombie.exception.InvalidMovementException;
import com.gino.zombie.exception.ZombieException;
import com.gino.zombie.model.Coordinates;
import com.gino.zombie.model.Zombie;
import com.gino.zombie.service.ZombieService;

@SpringBootTest
class ZombieControllerTest {

	MockMvc mockMvc;

	@MockBean
	ZombieService zombieService;

	@Autowired
	WebApplicationContext wac;

	@BeforeEach
	void beforeEach() {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	void test_shouldReturnHttpStatus200() throws Exception {

		when(zombieService.sayHello()).thenReturn("Grar");

		mockMvc.perform(get(ZombieConstants.Url.HELLO).characterEncoding(StandardCharsets.UTF_8.displayName()))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().string("Grar"));
	}

	@Test
	void test_shouldAlsoReturnHttpStatus200() throws Exception {

		final List<Coordinates> zombiesInitialPositions = List.of(new Coordinates(3, 1));
		final List<Coordinates> creaturesInitialPositions = List.of(new Coordinates(0, 1), new Coordinates(1, 2),
				new Coordinates(1, 1));
		final int gridSize = 4;
		final String movements = "RDRU";

		when(zombieService.wander(zombiesInitialPositions, creaturesInitialPositions, gridSize, movements))
				.thenReturn("success");

		Zombie param = new Zombie();
		param.setInitialPositions(zombiesInitialPositions);
		param.setCreaturesPositions(creaturesInitialPositions);
		param.setGridSize(gridSize);
		param.setMovements(movements);

		ObjectMapper mapper = new ObjectMapper();
		String requestJson = mapper.writeValueAsString(param);

		mockMvc.perform(post(ZombieConstants.Url.WANDER).content(requestJson)
				.characterEncoding(StandardCharsets.UTF_8.displayName()).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().string("success"));
	}

	@Test
	void test_shouldReturnHttpStatus400() throws Exception {

		final InvalidMovementException exception = new InvalidMovementException("Invalid zombie movement");

		final List<Coordinates> zombiesInitialPositions = List.of(new Coordinates(3, 1));
		final List<Coordinates> creaturesInitialPositions = List.of(new Coordinates(0, 1), new Coordinates(1, 2),
				new Coordinates(1, 1));
		final int gridSize = 4;
		final String movements = "RDRX";

		when(zombieService.wander(zombiesInitialPositions, creaturesInitialPositions, gridSize, movements))
				.thenThrow(exception);

		Zombie param = new Zombie();
		param.setInitialPositions(zombiesInitialPositions);
		param.setCreaturesPositions(creaturesInitialPositions);
		param.setGridSize(gridSize);
		param.setMovements(movements);

		ObjectMapper mapper = new ObjectMapper();
		String requestJson = mapper.writeValueAsString(param);

		mockMvc.perform(post(ZombieConstants.Url.WANDER).content(requestJson)
				.characterEncoding(StandardCharsets.UTF_8.displayName()).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void test_shouldReturnHttpStatus500() throws Exception {

		final ZombieException exception = new ZombieException("The value of the position does not fit in the grid.");
		final List<Coordinates> zombiesInitialPositions = List.of(new Coordinates(3, 1));
		final List<Coordinates> creaturesInitialPositions = List.of(new Coordinates(0, 1), new Coordinates(1, 2),
				new Coordinates(1, 1));
		final int gridSize = 2;
		final String movements = "RDRU";

		when(zombieService.wander(zombiesInitialPositions, creaturesInitialPositions, gridSize, movements))
				.thenThrow(exception);

		Zombie param = new Zombie();
		param.setInitialPositions(zombiesInitialPositions);
		param.setCreaturesPositions(creaturesInitialPositions);
		param.setGridSize(gridSize);
		param.setMovements(movements);

		ObjectMapper mapper = new ObjectMapper();
		String requestJson = mapper.writeValueAsString(param);

		mockMvc.perform(post(ZombieConstants.Url.WANDER).content(requestJson)
				.characterEncoding(StandardCharsets.UTF_8.displayName()).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isInternalServerError());
	}

}
