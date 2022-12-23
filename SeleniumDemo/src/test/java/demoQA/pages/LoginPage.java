package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class LoginPage extends PageObjectBase{
	private final String url = "login";
	public LoginPage(WebDriver driver, String url) {
		super(driver, url);
		// TODO Auto-generated constructor stub
	}
	
	public LoginPage navigate() {
		this.navigate(url);
		return this;
	}

	public ProfilePage sendCredentials(String user, String pass) {
		WebElement username = this.getDriver().findElement(By.id("userName"));
		WebElement password = this.getDriver().findElement(By.id("password"));
		WebElement login_btn = this.getDriver().findElement(By.id("login"));

		this.WaitUntilClickable(password);
		
		username.sendKeys(user);
		password.sendKeys(pass);
		login_btn.click();
		
		return new ProfilePage(this.getDriver(),this.getBaseUrl());
	}

	
	
	
}
