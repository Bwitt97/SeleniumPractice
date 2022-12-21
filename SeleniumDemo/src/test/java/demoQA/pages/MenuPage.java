package demoQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Framework.PageObjectBase;

public class MenuPage extends PageObjectBase{
	private final String url = "menu";
	public MenuPage(WebDriver driver, String url) {
		super(driver, url);
		// TODO Auto-generated constructor stub
	}
	
	public MenuPage navigate() {
		this.navigate(url);
		return this;
	}
	
	public MenuPage moveToAnchorByInnerText(String string) {
		Actions act = new Actions(this.getDriver());
		WebElement element = this.getElement(".//a[contains(text(),'"+string+"')]");
		act.moveToElement(element).perform();
		return this;
	}



	public Boolean isAnchorDisplayedByInnerText(String string) {
		WebElement element = this.getElement(".//a[contains(text(),'"+string+"')]");
		return element.isDisplayed();
	}


	
}
