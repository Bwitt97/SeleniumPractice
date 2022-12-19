package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.PageObjectBase;

public class HomePageObject extends PageObjectBase {
	private final String extension = "";
	public HomePageObject(WebDriver driver, String url) {
		super(driver, url);


	}

	public HomePageObject navigate() {
		this.navigate(extension);
		return this;
	}

	public LoginPageObject loginPage() {
		WebElement login_btn = this.getElement(".//div[@id='buttons']/ytd-button-renderer/yt-button-shape/a/yt-touch-feedback-shape/div/div[2]");
		login_btn.click();
		return new LoginPageObject(this.getDriver(),this.getBaseUrl());
	}
	
	public ResultPage search(String text)
	{
		WebElement searchbar = this.getElement(".//input[@id='search']");
		searchbar.sendKeys(text);
		searchbar.click();
		searchbar.sendKeys(Keys.RETURN);
		
	
		return new ResultPage(this.getDriver(),this.getBaseUrl());
		
	}
	
	


}
