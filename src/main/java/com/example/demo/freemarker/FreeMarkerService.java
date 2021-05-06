package com.example.demo.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.freemarker.entity.CustomDuty;
import com.example.demo.freemarker.entity.User;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

@Service
public class FreeMarkerService {

	private static final String ATTACHMENT_PATH = "";

	private static final String PATH = "templates/fthl";

	@Autowired
	private Configuration configuration;

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail() throws MessagingException, IOException, TemplateException {

		User user = new User("dejvis", "dejvis06", "dbeqiraj@tetra.al");

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setSubject("Welcome To SpringHow.com");
		helper.setFrom("_mainaccount@profisc.al");
		helper.setTo(user.getEmail());

		String emailContent = getEmailContent(user);
		helper.setText(emailContent, true);
		System.err.println(emailContent);

		FileSystemResource file = new FileSystemResource(new File(ATTACHMENT_PATH));
		helper.addAttachment("test", file);

		javaMailSender.send(mimeMessage);
	}

	private String getEmailContent(User user) throws IOException, TemplateException {

		FileTemplateLoader templateLoader = new FileTemplateLoader(
				new File(getClass().getClassLoader().getResource(PATH).getPath()));
		configuration.setTemplateLoader(templateLoader);

		StringWriter stringWriter = new StringWriter();
		Map<String, Object> model = new HashMap<>();

		model.put("user", user);

		configuration.getTemplate("email_user.ftl").process(model, stringWriter);
		return stringWriter.getBuffer().toString();
	}

	public String getEmailContent(CustomDuty customDuty) throws IOException, TemplateException {

		FileTemplateLoader templateLoader = new FileTemplateLoader(
				new File(getClass().getClassLoader().getResource(PATH).getPath()));
		configuration.setTemplateLoader(templateLoader);

		StringWriter stringWriter = new StringWriter();
		Map<String, Object> model = new HashMap<>();

		model.put("awb_nr", customDuty.getAwbNo());
		model.put("custom_duty_val", customDuty.getValue());
		model.put("custom_duty_dhl_val", customDuty.getDhlValue());
		model.put("custom_duty_curr", customDuty.getCurrency());
		model.put("custom_duty_tot_val", customDuty.getTotalValue());

		configuration.getTemplate("email_dhl.ftl").process(model, stringWriter);
		return stringWriter.getBuffer().toString();
	}
}
