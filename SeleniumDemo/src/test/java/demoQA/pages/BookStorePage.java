package demoQA.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class BookStorePage extends PageObjectBase{

	private final String url = "bookstore";
	protected BookStorePage(WebDriver driver, String url) {
		super(driver, url);
	}
	public BookStorePage search(String criteria) {
		WebElement searchbox = this.getDriver().findElement(By.id("searchBox"));
		this.WaitUntilClickable(searchbox);
		searchbox.sendKeys(criteria);
		return this;
	}
	public BookStorePage addBook(String title) {
		WebElement book = this.getElement(".//a[contains(text(),'"+title+"')]");
		this.ScrollElementIntoView(book);
		this.WaitUntilClickable(book);
		book.click();
		
		
		WebElement add = this.getDriver().findElement(By.xpath(".//button[contains(text(),'Add To Your Collection')]"));
		this.ScrollElementIntoView(add);
		this.WaitUntilClickable(add);
		add.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Alert alert = this.getDriver().switchTo().alert();
			alert.accept();
		}
		catch(NoAlertPresentException e){
			System.err.println("*****NO ALERT MESSAGE DETECTED*****");
		}
		return this;
	}
	public ProfilePage goToProfile() {
		this.navigate("profile");
		return new ProfilePage(this.getDriver(),this.getBaseUrl());
	}
	

	
}
