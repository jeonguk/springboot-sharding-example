package com.jeonguk.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Resource
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/")
	public Object index() {
		jdbcTemplate.update("INSERT INTO user(id, username) VALUES (1, 'alpha')");
		jdbcTemplate.update("INSERT INTO user(id, username) VALUES (2, 'beta')");
		jdbcTemplate.update("INSERT INTO user(id, username) VALUES (3, 'gamma')");
		jdbcTemplate.update("INSERT INTO user(id, username) VALUES (4, 'theta')");
		List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM user WHERE id IN (0,1,2,3,4,5,6,7)");
		System.out.println(maps);
		return maps;
	}

}
