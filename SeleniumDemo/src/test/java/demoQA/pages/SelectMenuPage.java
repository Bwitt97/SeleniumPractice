package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class SelectMenuPage extends PageObjectBase{
	
	private final String url = "select-menu";
	public SelectMenuPage(WebDriver driver, String url) {
		super(driver, url);
		// TODO Auto-generated constructor stub
	}
	
	public SelectMenuPage navigate() {
		this.navigate(url);
		return this;
	}
	
	public SelectMenuPage clickOptionByValue(String string) {
		
		WebElement option = this.getElement(".//option[@value='"+string+"']");
		this.WaitUntilClickable(option);
		option.click();
		return this;
	}

	public SelectMenuPage clickById(String string) {
		WebElement element =this.getDriver().findElement(By.id(string));
		this.ScrollElementIntoView(element);
		this.WaitUntilClickable(element);
		element.click();
		return this;
	}

	public boolean confirmValueSelected(String color) {
		
		return this.getDriver().findElement(By.id("oldSelectMenu")).getAttribute("value").equals(color);
	}



}
