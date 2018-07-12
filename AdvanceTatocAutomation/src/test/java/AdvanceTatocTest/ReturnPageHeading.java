package AdvanceTatocTest;

import static AdvanceTatocTest.RetrieveLocators.element;


public class ReturnPageHeading {

	public String returnPageHeadingText() {
		return element("getPageHeadingText").getText();
	}
}
