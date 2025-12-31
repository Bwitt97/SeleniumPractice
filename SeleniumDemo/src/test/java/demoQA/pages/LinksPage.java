package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class LinksPage extends PageObjectBase{
	private final String url = "links";
	public LinksPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public LinksPage navigate() {
		this.navigate(url);
		return this;
	}
	
	public LinksPage selectLinkById(String string) {
		WebElement link = this.getDriver().findElement(By.id(string));
		this.WaitUntilClickable(link);
		link.click();
		this.activateNewTab();
		return this;
	}

}
