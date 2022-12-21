package demoQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class TextBoxPage extends PageObjectBase{

	private String url = "text-box";
	public TextBoxPage(WebDriver driver, String url) {
		super(driver, url);
	}
	public TextBoxPage navigate() {
		this.navigate(url);
		return this;
	}
	public TextBoxPage EnterCredentials() {
		WebElement fullname = this.getElement(".//input[@id='userName']");
		WebElement email = this.getElement(".//input[@id='userEmail']");
		WebElement address = this.getElement(".//textarea[@id='currentAddress']");
		WebElement perm_address = this.getElement(".//textarea[@id='permanentAddress']");
		
		fullname.sendKeys("Brandon Witt");
		email.sendKeys("brandonwitt@email.com");
		address.sendKeys("Address nw 29th ave");
		perm_address.sendKeys("Address apt 10 nw 22070");
		
		WebElement submit_btn=this.getElement(".//button[@id='submit']");
		this.ScrollElementIntoView(submit_btn);
		this.WaitUntilClickable(submit_btn);

		submit_btn.click();
		
		return this;
	}
	public Boolean outputIsVisible() {
		if(this.getElement(".//div[@id='output']") != null)
			return true;
		else
			return false;
	}

}
