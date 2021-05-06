package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dozer.DozerService;
import com.example.demo.freemarker.FreeMarkerService;
import com.example.demo.freemarker.User;
import com.example.demo.thymeleaf.ThymeleafService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ThymeleafService thymeleafService;

	@Autowired
	private FreeMarkerService freeMarkerService;

	@Autowired
	private DozerService dozerService;

	// @Test
	void generatePdfFromHtml() {
		try {

			thymeleafService.generatePdfFromHtml();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test
	void getEmailContent() {
		try {

			// System.err.println(freeMarkerService.getEmailContent(new User("dejvis",
			// "dejvis06", "dbeqiraj@tetra.al")));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test
	void convertPersonneToPerson() {
		try {

			dozerService.convertPersonneToPerson();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
