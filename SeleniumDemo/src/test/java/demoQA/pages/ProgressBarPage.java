package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class ProgressBarPage extends PageObjectBase {
	
	private final String url = "progress-bar";
	public ProgressBarPage(WebDriver driver, String url) {
		super(driver, url);
	}

	public ProgressBarPage navigate() {
		this.navigate(url);
		return this;
	}
	
	public ProgressBarPage stopAtValue(String string) {
		WebElement progressBar= this.getDriver().findElement(By.xpath(".//div[@role='progressbar']"));
		
		//START
		WebElement btn=this.getDriver().findElement(By.xpath(".//div[@id='progressBarContainer']/button"));
		btn.click();
		while(this.getValueOfProgressBar().equals("100")==false)
		{
			if(this.getValueOfProgressBar().equals(string)) {
				btn.click();
				break;}
		}
		
		
		if(this.getValueOfProgressBar().equals(string)!=true)
		{
			btn=this.getDriver().findElement(By.xpath(".//div[@id='progressBarContainer']/button"));
			btn.click();
			return this.stopAtValue(string);
		}
		
		return this;
	}
	

	
	public String getValueOfProgressBar() {
		
		return this.getDriver().findElement(By.xpath(".//div[@role='progressbar']")).getAttribute("aria-valuenow");
	}
}
