package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class TabsPage extends PageObjectBase{

	private final String url = "tabs";
	public TabsPage(WebDriver driver, String url) {
		super(driver, url);
		// TODO Auto-generated constructor stub
	}
	
	public TabsPage navigate() {
		this.navigate(url);
		return this;
	}
	
	
	public Boolean checkIfActive(String string) {
		WebElement element = this.getDriver().findElement(By.id(string));
		if(element.getAttribute("class").equals("nav-item nav-link active"))
			return true;
		else
			return false;
		
	}

	
	public TabsPage clickById(String string) {
		WebElement element =this.getDriver().findElement(By.id(string));
		this.ScrollElementIntoView(element);
		this.WaitUntilClickable(element);
		element.click();
		return this;
	}
}
