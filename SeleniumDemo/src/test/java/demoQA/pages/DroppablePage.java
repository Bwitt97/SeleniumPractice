package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Framework.PageObjectBase;

public class DroppablePage extends PageObjectBase {
	private final String url = "droppable";
	public DroppablePage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public DroppablePage navigate() {
		this.navigate(url);
		return this;
	}

	public DroppablePage draganddrop(String source, String target) {
		WebElement source_item = this.getDriver().findElement(By.id(source));
		WebElement target_item = this.getDriver().findElement(By.id(target));
		
		Actions act = new Actions(this.getDriver());
		
		act.dragAndDrop(source_item, target_item).perform();
		return this;
	}

	public boolean confirmDropped() {
		if(this.getElement(".//p[contains(text(),'Dropped!')]").isDisplayed())
			return true;
		else
			return false;
	}

}
