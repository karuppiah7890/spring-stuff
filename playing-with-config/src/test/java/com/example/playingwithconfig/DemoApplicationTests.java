package com.example.playingwithconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Value("${customConfig}")
	String customConfig;

	@Value("${anotherCustomConfig}")
	String anotherCustomConfig;

	@Test
	void contextLoads() {
		assertEquals("someValue", customConfig);
		assertEquals("anotherValue", anotherCustomConfig);
	}

}
