package invenAuto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class LoginPage extends PageObjectBase{

	public LoginPage(WebDriver driver, String url) {
		super(driver, url);
	}

	public LoginPage enterLoginInfo(String user, String pass) {
		WebElement username = this.getDriver().findElement(By.id("email"));
		
		WebElement password = this.getDriver().findElement(By.id("passwd"));
		WebElement submit_btn=this.getDriver().findElement(By.id("SubmitLogin"));
		
		username.sendKeys(user);
		password.sendKeys(pass);
		submit_btn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return this;
	}
	
	
	
	

}
