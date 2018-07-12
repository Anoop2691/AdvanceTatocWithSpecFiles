package AdvanceTatocTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class FunctionsForTatocAdvanceCourse extends RetrieveLocators{
	AdvanceCourseFirstPage objectForAdvanceCourseFirstPage;
	TestingHoverMenuSecondPage objectForTestingHoverMenuSecondPage;
	TestingQueryGateThirdPage objectForTestingCorrectCredentialsThirdPage;
	TestingRestPageByAddingSession objectForTestingRestPageByAddingSession;
	TestingFileHandlePage objectForTestingFileHandlePage;
	public FunctionsForTatocAdvanceCourse(WebDriver driver){
		super(driver);
		objectForAdvanceCourseFirstPage =new AdvanceCourseFirstPage();
		objectForTestingHoverMenuSecondPage= new TestingHoverMenuSecondPage(driver);
		 objectForTestingCorrectCredentialsThirdPage= new TestingQueryGateThirdPage();
		 objectForTestingRestPageByAddingSession=new TestingRestPageByAddingSession();
		 objectForTestingFileHandlePage= new TestingFileHandlePage();
	}
	public void firstPageClickingOnAdvanceCourse() {
		objectForAdvanceCourseFirstPage.clickOnWebElement();
		Assert.assertTrue(objectForAdvanceCourseFirstPage.returnPageHeadingText().contains("Hover Menu"));
	}
	public void secondPageClickingOnGoNextInDropdownMenu2() {
		objectForTestingHoverMenuSecondPage.goingToDropdownMenu2AndClickingGoNext();
		Assert.assertTrue(objectForTestingHoverMenuSecondPage.returnPageHeadingText().contains("Query Gate"));
	}
	public void thirdPageRetrievingDatabaseDataInThirdPage() {
		objectForTestingCorrectCredentialsThirdPage.queryPerforming();
		Assert.assertTrue(objectForTestingCorrectCredentialsThirdPage.returnPageHeadingText().contains("Ooyala Video Player"));
		driver.get("http://10.0.1.86/tatoc/advanced/rest");
		
	}
	public void fifthPageAddingCookieUsingSessionIdAndRegisterRestService() throws IOException {
		objectForTestingRestPageByAddingSession.generatingTokenAndRegisterRestService();
		System.out.println(driver.getTitle());
		Assert.assertEquals("Restful - Advanced Course - T.A.T.O.C",driver.getTitle());	
	}
	public void sixthPageDownloadFileAddSignature() throws IOException, InterruptedException {
		objectForTestingFileHandlePage.downloadFileAndReadSignature();
		Assert.assertTrue(driver.findElement(By.className("finish")).getText().contains("End"));	
	}
}