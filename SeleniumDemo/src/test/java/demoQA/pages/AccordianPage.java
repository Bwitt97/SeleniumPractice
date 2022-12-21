package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class AccordianPage extends PageObjectBase{

	private final String url = "accordian";
	public AccordianPage(WebDriver driver, String url) {
		super(driver, url);
	}
	public AccordianPage navigate() {
		this.navigate(url);
		return this;
	}

	
	public AccordianPage clickById(String string) {
		WebElement element =this.getDriver().findElement(By.id(string));
		this.ScrollElementIntoView(element);
		this.WaitUntilClickable(element);
		element.click();
		return this;
	}



	public Boolean confirmVisable(String string) {
		WebElement block = this.getDriver().findElement(By.id(string));
		if(block.isDisplayed())
			return true;
		else
			return false;
	}
}
