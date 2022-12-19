package demoQA.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Framework.PageObjectBase;

public class HomePage extends PageObjectBase{
  public HomePage(WebDriver driver, String url) {
		super(driver, url);
	}

public HomePage navigate() {
	this.navigate("");
	return this;
}

public ElementsPage elements() {
    WebElement element = this.getElement(".//h5[contains(text(),'Elements')]");
    this.ScrollElementIntoView(element) ;
    this.WaitUntilClickable(element);
    element.click();
	return new ElementsPage(this.getDriver(), this.getBaseUrl());
}
}
