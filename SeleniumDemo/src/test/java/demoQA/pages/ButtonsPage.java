package demoQA.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Framework.PageObjectBase;

public class ButtonsPage extends PageObjectBase{
	private final String url = "buttons";

	public ButtonsPage(WebDriver driver, String url) {
		super(driver, url);
		// TODO Auto-generated constructor stub
	}
	
	public ButtonsPage navigate() {
		this.navigate(url);
		return this;
	}
	

	public ButtonsPage doubleClick(String string) {
		WebElement btn=this.getElement(".//button[@id='"+string+"']");
		this.WaitUntilClickable(btn);
		new Actions(this.getDriver()).doubleClick(btn).perform();
		return this;
	}

	public ButtonsPage rightClick(String string) {
		WebElement btn=this.getElement(".//button[@id='"+string+"']");
		this.WaitUntilClickable(btn);
		new Actions(this.getDriver()).contextClick(btn).perform();
		return this;
	}
	
	public ButtonsPage clickButtonByIndex(int i) {
		List<WebElement> btns = this.getDriver().findElements(By.xpath(".//button[@class='btn btn-primary']"));
		
		btns.get(i).click();
		
		return this;
	}

	public Boolean assertButtonPrompts() {
		WebElement doubleclick = this.getDriver().findElement(By.id("doubleClickMessage"));
		WebElement rightclick = this.getDriver().findElement(By.id("rightClickMessage"));
		WebElement dynamicclick = this.getDriver().findElement(By.id("dynamicClickMessage"));
		if(doubleclick.isDisplayed() && rightclick.isDisplayed() && dynamicclick.isDisplayed())
			return true;
		else
			return false;
	}

}
