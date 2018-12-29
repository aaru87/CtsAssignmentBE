package org.rebo.statementprocessor.reportgenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.rebo.statementprocessor.util.Configuration;
import org.rebo.statementprocessor.validator.RecordValidator;

public class ReportGenerator {

	public StringBuilder templateContent = new StringBuilder("");
	private String TEMPLATE_FILE_PATH = Configuration.getInstance().getPropertyByKey("templateHtml");
	private RecordValidator validator;
	private String reportPath = Configuration.getInstance().getPropertyByKey("ReportPath");

	public ReportGenerator(RecordValidator validator) {
		this.validator = validator;
	}

	private void getHtmlTemplateContent() {

		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(TEMPLATE_FILE_PATH).getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				templateContent.append(line).append("\n");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean generateReport() {
		try (
			FileWriter reportFile = new FileWriter(reportPath + File.separator + "report.html")) {
			getHtmlTemplateContent();
			System.out.println("Validator content" + this.validator.reportBuilder);
			System.out.println("Template content" + templateContent.toString());
			String htmlContent = templateContent.toString();
			htmlContent = htmlContent.replace("<tr></tr>", this.validator.reportBuilder);
			reportFile.write(htmlContent.toString());
			System.out.println("Final" + htmlContent);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
