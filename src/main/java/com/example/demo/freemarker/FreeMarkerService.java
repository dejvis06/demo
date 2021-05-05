package com.example.demo.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

@Service
public class FreeMarkerService {

	private static final String ATTACHMENT_PATH = "";

	private static final String PATH = "C:\\Users\\dbeqiraj\\git\\demo\\src\\main\\resources\\templates\\pdf";

	@Autowired
	private Configuration configuration;

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail() throws MessagingException, IOException, TemplateException {

		User user = new User("dejvis", "dejvis06", "dbeqiraj@tetra.al");

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

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

		FileTemplateLoader templateLoader = new FileTemplateLoader(new File(PATH));
		configuration.setTemplateLoader(templateLoader);

		StringWriter stringWriter = new StringWriter();
		Map<String, Object> model = new HashMap<>();

		model.put("user", user);

		configuration.getTemplate("email.ftlh").process(model, stringWriter);
		return stringWriter.getBuffer().toString();
	}
}
