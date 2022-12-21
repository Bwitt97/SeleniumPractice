package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class BrowserWindowsPage extends PageObjectBase{
	private final String url = "browser-windows";
	public BrowserWindowsPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public BrowserWindowsPage navigate() {
		this.navigate(url);
		return this;
	}
	
	public BrowserWindowsPage clickButtonById(String string) {
		WebElement btn = this.getDriver().findElement(By.id(string));
		btn.click();
		return this;
	}
	
	public BrowserWindowsPage activateTab()
	{
		this.activateNewTab();
		return this;
	}

}
