package AdvanceTatocTest;

import static AdvanceTatocTest.RetrieveLocators.element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TestingHoverMenuSecondPage extends ReturnPageHeading{
	WebDriver driver;
	public TestingHoverMenuSecondPage(WebDriver driver) {
		this.driver=driver;
	}
	public void goingToDropdownMenu2AndClickingGoNext() {
		Actions action = new Actions(driver);
		action.moveToElement(element("findElementMenuTitleMenu2"));
		action.moveToElement(element("findElementGoNext"));
		action.click().build().perform();
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
}
