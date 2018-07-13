package AdvanceTatocTest;

public class AdvanceCourseFirstPage extends RetrieveLocators {
	public  AdvanceCourseFirstPage() {
		super("BasicCourse");
	}
	public void clickOnWebElement()  {
		element("finElementAdvanceCourseLink").click();
	}
	public String returnPageHeadingText() {
		return element("getPageHeadingText").getText();
	}
}
