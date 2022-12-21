package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class NestedFramesPage extends PageObjectBase{

	private final String url = "nestedframes";
	public NestedFramesPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public NestedFramesPage navigate() {
		this.navigate(url);
		return this;
	}
	
	public NestedFramesPage switchToFrame(String string) {
		WebElement frame = this.getDriver().findElement(By.id(string));
		this.getDriver().switchTo().frame(frame);
		return this;
	}

	public String getAllTextFromBody() {
		return this.getDriver().findElement(By.tagName("body")).getAttribute("innerText");
	}
	
	
	public NestedFramesPage switchToFrameByXpath(String xpath) {
		this.getDriver().switchTo().frame(this.getElement(xpath));
		return this;
	}



	public String getAllTextFromP() {
		return this.getDriver().findElement(By.tagName("p")).getAttribute("innerText");

	}
}
