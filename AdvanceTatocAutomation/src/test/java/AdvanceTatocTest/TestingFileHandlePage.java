package AdvanceTatocTest;

import java.io.File;
import static AdvanceTatocTest.RetrieveLocators.element;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestingFileHandlePage {

	public void downloadFileAndReadSignature() throws InterruptedException {
		element("downloadFile").click();
		Thread.sleep(5000);		
		File file = new File("C:\\Users\\anoopkumar\\Downloads\\file_handle_test.dat");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		element("signature").sendKeys(prop.getProperty("Signature"));
		element("submit").click();
		file.delete();
	}
}
