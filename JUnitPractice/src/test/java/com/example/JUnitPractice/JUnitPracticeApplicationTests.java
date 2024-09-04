package com.example.JUnitPractice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class JUnitPracticeApplicationTests {

	@Test
	void contextLoads() {
		//fail("Not Yet Implemented");
	}

	@Test
	void test(){
		assertEquals(2,2);
	}



}
