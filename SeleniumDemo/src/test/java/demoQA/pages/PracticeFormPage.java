package demoQA.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class PracticeFormPage extends PageObjectBase{

	private final String url = "automation-practice-form";
	public PracticeFormPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public PracticeFormPage navigate() {
		this.navigate(url);
		return this;
	}
	
	public PracticeFormPage RegisterStudent(String[] userInfo) {
		WebElement firstname = this.getDriver().findElement(By.id("firstName"));
		WebElement lastname = this.getDriver().findElement(By.id("lastName"));
		WebElement email = this.getDriver().findElement(By.id("userEmail"));
		WebElement gender = this.getDriver().findElement(By.xpath(".//label[contains(text(),'"+userInfo[3]+"')]"));
		WebElement number = this.getDriver().findElement(By.id("userNumber"));
		WebElement birth = this.getDriver().findElement(By.id("dateOfBirthInput"));
		//WebElement subject = this.getDriver().findElement(By.id("subjectsContainer"));
		WebElement hobby = this.getDriver().findElement(By.xpath(".//label[contains(text(),'"+userInfo[7]+"')]"));
		WebElement upload = this.getDriver().findElement(By.id("uploadPicture"));
		WebElement address = this.getDriver().findElement(By.id("currentAddress"));
		WebElement state = this.getDriver().findElement(By.id("state"));
		WebElement city = this.getDriver().findElement(By.id("city"));
		
		
		
		firstname.sendKeys(userInfo[0]);
		lastname.sendKeys(userInfo[1]);
		email.sendKeys(userInfo[2]);
		this.WaitUntilClickable(gender);
		gender.click();
		number.sendKeys(userInfo[4]);
		birth.sendKeys(userInfo[5],Keys.ENTER);
		//subject.sendKeys(userInfo[6]);
		this.ScrollElementIntoView(hobby);
		this.WaitUntilClickable(hobby);
		hobby.click();
		this.ScrollElementIntoView(upload);
		upload.sendKeys(userInfo[8]);
		this.ScrollElementIntoView(state);
		address.sendKeys(userInfo[9]);
		//state.click();
		//cannot pick state or submit because adds are in the way
		//report bug
		
		return this;
	}

	public boolean checkForAds() {
		return this.getElement(".//iframe").isDisplayed();
			}
}
