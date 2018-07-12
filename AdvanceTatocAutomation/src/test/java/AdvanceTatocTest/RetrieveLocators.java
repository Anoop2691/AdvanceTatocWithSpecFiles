package AdvanceTatocTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RetrieveLocators {
	public static WebDriver driver;
	public RetrieveLocators(WebDriver driver) {
		this.driver=driver;
	}
	public static String[] readSpecFile(String ElementName) {
		BufferedReader reader;
		ArrayList<String> elementLines=new ArrayList<String>();
		String[] elementLineSplit;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\anoopkumar\\eclipse-workspace\\AdvanceTatocAutomation\\src\\test\\java\\AdvanceTatocTest\\testPage.spec"));
			String line;
			while((line = reader.readLine()) != null) {
				elementLines.add(line.trim().replaceAll("[ \t]+", " "));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String elementLine : elementLines) {
		      elementLineSplit = elementLine.split(" ");

		      if (elementLineSplit[0].trim().equalsIgnoreCase(ElementName)) {
		        return elementLine.split(" ", 3);
		      } else {
		        continue;
		      }
		    }
		return null;
	}
	public static WebElement selectSelector(String[] element) {
		switch(element[1]) {
		case "id":System.out.println(element[2]);return driver.findElement(By.id(element[2]));
		case "className":System.out.println(element[2]);return driver.findElement(By.className(element[2]));
		case "cssSelector":System.out.println(element[2]);return driver.findElement(By.cssSelector(element[2]));
		case "linkText":System.out.println(element[2]);return driver.findElement(By.linkText(element[2]));
		default:System.out.println(element[2]);return driver.findElement(By.xpath(element[2]));
		}
	}
	public static WebElement element(String elementName){
		String[] ElementDetails= readSpecFile(elementName);
		return selectSelector(ElementDetails);
	}
}
