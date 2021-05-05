package com.example.demo.thymeleaf;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

@Service
public class ThymeleafService {

	private String parseThymeleafTemplate() {

		TemplateEngine templateEngine = new TemplateEngine();

		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("templates" + File.separator + "pdf" + File.separator);
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);

		templateEngine.setTemplateResolver(templateResolver);

		Context context = new Context();
		context.setVariable("bank", "Intesa SanPaolo Bank test");
		context.setVariable("accountName", "DHL International (Albania) SHPK test");
		context.setVariable("accountNo", "20019735304 test");
		context.setVariable("iban", "AL25208110080000020019735304 test");
		context.setVariable("currency", "ALL test");

		return templateEngine.process("dhl", context);
	}

	public void generatePdfFromHtml() throws IOException, DocumentException {

		String html = parseThymeleafTemplate();

		String outputFolder = "C:\\Users\\dbeqiraj\\Desktop\\thymeleaf.pdf";
		OutputStream outputStream = new FileOutputStream(outputFolder);

		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(html);
		renderer.layout();
		renderer.createPDF(outputStream);

		outputStream.close();

	}
}
