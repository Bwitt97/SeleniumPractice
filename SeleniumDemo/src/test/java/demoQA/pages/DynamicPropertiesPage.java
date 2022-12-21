package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class DynamicPropertiesPage extends PageObjectBase{
	private final String url = "dynamic-properties";
	public DynamicPropertiesPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public DynamicPropertiesPage navigate() {
		this.navigate(url);
		return this;
	}
	
	public String getButtonTextById(String string) {
		WebElement btn = this.getDriver().findElement(By.id(string));
		
		return btn.getAttribute("innerHTML");
	}



	public DynamicPropertiesPage printTextIdByXpath(String string) {
		WebElement text = this.getElement(string);
		System.out.println(text.getAttribute("id"));
		return this;
	}

}
