package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.thymeleaf.ThymeleafService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ThymeleafService thymeleafService;

	@Test
	void generatePdfFromHtml() {
		try {

			thymeleafService.generatePdfFromHtml();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
