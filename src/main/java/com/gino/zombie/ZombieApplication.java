package com.gino.zombie;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

@SpringBootApplication
@RestController
public class ZombieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZombieApplication.class, args);
	}
	
	@Hidden
	@GetMapping("/")
	public void home(final HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui/index.html?url=/v3/api-docs");
	}
	
}
