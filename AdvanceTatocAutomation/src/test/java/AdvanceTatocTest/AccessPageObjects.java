package AdvanceTatocTest;

import org.openqa.selenium.WebDriver;
import AdvanceTatocTest.RetrieveLocators;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class AccessPageObjects extends RetrieveLocators{
	WebDriver driver; 
	FunctionsForTatocAdvanceCourse objectToAccessFunction;
	public AccessPageObjects(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	  RetrieveLocators rl;
	  public void openLinkAndCreateObjects() {
		  
	  }
}
