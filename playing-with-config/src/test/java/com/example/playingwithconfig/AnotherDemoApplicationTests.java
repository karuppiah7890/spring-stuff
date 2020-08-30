package com.example.playingwithconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles({"anotherProfile"})
class AnotherDemoApplicationTests {
    @Value("${customConfig}")
    String customConfig;

    @Value("${anotherCustomConfig}")
    String anotherCustomConfig;

    @Test
    void contextLoads() {
        assertEquals("someTestSecondaryValue", customConfig);
        assertEquals("anotherTestValue", anotherCustomConfig);
    }
}