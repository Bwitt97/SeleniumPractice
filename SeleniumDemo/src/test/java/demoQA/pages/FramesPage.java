package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class FramesPage extends PageObjectBase {
	private final String url = "frames"	;
	public FramesPage(WebDriver driver, String url) {
		super(driver, url);
	}

	public FramesPage navigate() {
		this.navigate(url);
		return this;
	}
	
	public FramesPage switchToFrame(String string) {
		WebElement frame = this.getDriver().findElement(By.id(string));
		this.getDriver().switchTo().frame(frame);
		return this;
	}



	public String getH1TextById(String string) {
		return this.getDriver().findElement(By.id(string)).getAttribute("innerHTML");
	}
}
