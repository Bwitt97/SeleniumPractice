package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Framework.PageObjectBase;

public class DragabblePage extends PageObjectBase{
	private final String url = "dragabble";
	public DragabblePage(WebDriver driver, String url) {
		super(driver, url);
		// TODO Auto-generated constructor stub
	}
	
	public DragabblePage navigate() {
		this.navigate(url);
		return this;
	}

	public DragabblePage drag(String id, int x, int y) {
		Actions act = new Actions(this.getDriver());
		WebElement dragabble = this.getDriver().findElement(By.id(id));
		this.WaitUntilClickable(dragabble);
		act.dragAndDropBy(dragabble, x, y).perform();
		return this;
	}

	public String getPosition(String id) {
		return this.getDriver().findElement(By.id(id)).getAttribute("style");
	}

}
