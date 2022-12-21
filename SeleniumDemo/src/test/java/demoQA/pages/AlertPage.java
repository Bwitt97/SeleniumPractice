package demoQA.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class AlertPage extends PageObjectBase{
	private final String url = "alerts";
	public AlertPage(WebDriver driver, String url) {
		super(driver, url);
	}

	public AlertPage navigate() {
		this.navigate(url);
		return this;
	}
	
	public AlertPage clickButtonById(String string) {
		WebElement btn = this.getDriver().findElement(By.id(string));
		btn.click();
		return this;
	}



	public Boolean checkForAlert() {
		int i=0;
		while(i++<10)
		{
			try {
				Alert alert = this.getDriver().switchTo().alert();
				alert.accept();
				break;
			}
			catch(NoAlertPresentException e){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				continue;
			}
		}
		if(i>=10)
			return false;
		return true;
	}
	
	
public Boolean alertOk() {
		
		try {
			Alert alert = this.getDriver().switchTo().alert();
			alert.accept();
		}
		catch(NoAlertPresentException e){
			System.err.println("*****NO ALERT MESSAGE DETECTED*****");
			return false;
		}
		
		return true;
	}

public AlertPage alertSendKeys(String string) {
	try {
		Alert alert = this.getDriver().switchTo().alert();
		alert.sendKeys(string);
		alert.accept();
	}
	catch(NoAlertPresentException e){
		System.err.println("*****NO ALERT MESSAGE DETECTED*****");
		return this;
	}
	
	

	return this;
}
public String getPrompt() {
	return this.getDriver().findElement(By.id("promptResult")).getAttribute("innerHTML");
}

}
