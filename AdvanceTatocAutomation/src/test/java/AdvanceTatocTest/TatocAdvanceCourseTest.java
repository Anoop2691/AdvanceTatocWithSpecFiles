package AdvanceTatocTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AdvanceTatocTest.AccessPageObjects;

public class TatocAdvanceCourseTest {
	WebDriver driver;
	FunctionsForTatocAdvanceCourse objectForAccessingFunctions;
	AccessPageObjects objectToInitializeClassInstance;
	 @BeforeClass
	 void DriverInitialization() {
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://10.0.1.86/tatoc");
		 Reporter.log("Launch application ", true);
		 objectForAccessingFunctions =new FunctionsForTatocAdvanceCourse(driver);
	 }
	  
 @Test
 void checkAfterClickingAdvanceCourse() {
	 objectForAccessingFunctions.firstPageClickingOnAdvanceCourse();
 }
 @Test(dependsOnMethods="checkAfterClickingAdvanceCourse")
 void checkAfterClickingGonextInMenu2InHoverPage() {
	 objectForAccessingFunctions.secondPageClickingOnGoNextInDropdownMenu2();
 }
 @Test(dependsOnMethods="checkAfterClickingGonextInMenu2InHoverPage")
 void checkAfterRetrievingValidDataFromDatabaseAbdSubmittingInQueryGatePage() {
	 objectForAccessingFunctions.thirdPageRetrievingDatabaseDataInThirdPage();
 }
 @Test(dependsOnMethods="checkAfterRetrievingValidDataFromDatabaseAbdSubmittingInQueryGatePage")
 void checkAfterGettingTokenForCurrentSessionIdAndRegisterRestService() throws IOException {
	 objectForAccessingFunctions.fifthPageAddingCookieUsingSessionIdAndRegisterRestService();
 }
 @Test(dependsOnMethods="checkAfterGettingTokenForCurrentSessionIdAndRegisterRestService")
 void checkAfterDownloadingFileAndAddingSignature() throws IOException, InterruptedException {
	 objectForAccessingFunctions.sixthPageDownloadFileAddSignature();
 }
 void closeBrowser() {
	 objectToInitializeClassInstance.driver.close();
 }
}
