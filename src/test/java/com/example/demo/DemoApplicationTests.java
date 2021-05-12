package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dozer.DozerService;
import com.example.demo.freemarker.FreeMarkerService;
import com.example.demo.freemarker.entity.CustomDuty;
import com.example.demo.freemarker.entity.User;
import com.example.demo.thymeleaf.ThymeleafService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ThymeleafService thymeleafService;

	@Autowired
	private FreeMarkerService freeMarkerService;

	@Autowired
	private DozerService dozerService;

	@Test
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

			// freeMarkerService.sendEmail();

			System.err.println(freeMarkerService.getEmailContent(
					new CustomDuty("test awbNo", "test value", "test currency", "test dhlValue", "test total value")));

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
