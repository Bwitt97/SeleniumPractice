package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Framework.PageObjectBase;

public class ToolTipsPage extends PageObjectBase{

	private final String url = "tool-tips";
	public ToolTipsPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	
	public ToolTipsPage navigate() {
		this.navigate(url);
		return this;
	}
	
	
	public Boolean confirmToolTipById(String string) {
		WebElement btn = this.getDriver().findElement(By.id(string));
		this.WaitUntilClickable(btn);
		Actions act = new Actions(this.getDriver());
		this.ScrollElementIntoView(btn);
		act.moveToElement(btn).perform();
		
		return this.WaitUntilAttributeVisible(btn, "aria-describedby");
		
		
	
		
	
	}

}
