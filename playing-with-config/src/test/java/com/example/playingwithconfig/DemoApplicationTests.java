package com.example.playingwithconfig;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

    @Value("${configThatDoesNotExist:defaultValue}")
    String configThatDoesNotExist;

    @Value("${interpolatedConfig}")
    String interpolatedConfig;

    @BeforeAll
    static void setup() {
        System.out.println("dummy");
    }

    @BeforeEach
    void setupForEach() {
        System.out.println("dummy");
    }

    @Test
    void contextLoads() {
        assertEquals("someTestValue", customConfig);
        assertEquals("anotherTestValue", anotherCustomConfig);
        assertEquals("defaultValue", configThatDoesNotExist);
        assertEquals("someTestValue-blah", interpolatedConfig);
    }

}
