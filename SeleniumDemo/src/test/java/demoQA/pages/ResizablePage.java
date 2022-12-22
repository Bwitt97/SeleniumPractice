package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Framework.PageObjectBase;

public class ResizablePage extends PageObjectBase{

	private final String url = "resizable";
	public ResizablePage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public ResizablePage navigate() {
		this.navigate(url);
		return this;
	}

	public ResizablePage resizebox( int xoffset, int yoffset) {
		
		 String xpath = ".//div[@id='resizableBoxWithRestriction']/span[@class='react-resizable-handle react-resizable-handle-se']";
		 WebElement handle = this.getElement(xpath);
		 Actions action = new Actions(this.getDriver());
		 this.ScrollElementIntoView(handle);
		 action.moveToElement(handle).perform();
		 action.clickAndHold().moveByOffset(xoffset, yoffset).release();
		 action.build().perform();
		return this;
	}

	public String getDimensions(String id) {
		String dimensions = this.getDriver().findElement(By.id(id)).getAttribute("style");
		return dimensions;
	}

}
