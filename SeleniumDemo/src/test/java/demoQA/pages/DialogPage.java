package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class DialogPage extends PageObjectBase{
	public DialogPage(WebDriver driver, String url) {
		super(driver, url);
		// TODO Auto-generated constructor stub
	}


	private final String url = "modal-dialogs";
	
	
	public DialogPage navigate() {
		this.navigate(url);
		return this;
	}

	public String getModelTextById(String string) {
		return this.getDriver().findElement(By.id(string)).getAttribute("innerText");
	}
	
	public DialogPage clickById(String string) {
		WebElement element =this.getDriver().findElement(By.id(string));
		this.ScrollElementIntoView(element);
		this.WaitUntilClickable(element);
		element.click();
		return this;
	}
}
