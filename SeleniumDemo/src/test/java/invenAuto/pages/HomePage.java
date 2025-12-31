package invenAuto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Framework.PageObjectBase;

public class HomePage extends PageObjectBase{

	public HomePage(WebDriver driver, String url) {
		super(driver, url);

	}
	
	public HomePage navigate()
	{
		this.navigate("");
		return this;
	}

	public LoginPage goToLogin() {
		WebElement signIn = this.getDriver().findElement(By.className("login"));
		signIn.click();
		return new LoginPage(this.getDriver(),this.getBaseUrl());
	}

}
