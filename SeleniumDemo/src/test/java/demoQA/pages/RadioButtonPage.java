package demoQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class RadioButtonPage extends PageObjectBase {
	private final String url = "radio-button";

	public RadioButtonPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public RadioButtonPage navigate()
	{
		this.navigate(url);
		return this;
	}
	
	public RadioButtonPage selectbylabel(String string) {
		WebElement btn = this.getElement(".//label[@for='"+string+"']");
		this.WaitUntilClickable(btn);
		btn.click();
		return this;
	}

	public String radiobutton_status() {
		return this.getElement(".//span[@class='text-success']").getAttribute("innerHTML");
	}

}
