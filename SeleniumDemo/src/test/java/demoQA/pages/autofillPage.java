package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Framework.PageObjectBase;

public class autofillPage extends PageObjectBase{
	private final String url = "auto-complete";
	public autofillPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public autofillPage navigate() {
		this.navigate(url);
		return this;
	}
	

	public autofillPage enterMultipleColorsById(String[] autofill_colors,String id) {
		String xpath = ".//div[@id='"+id+"']/div/div";
		Actions act = new Actions(this.getDriver());
		WebElement textbox = this.getDriver().findElement(By.xpath(xpath));
		this.ScrollElementIntoView(textbox);
		this.WaitUntilClickable(textbox);
		textbox.click();
		act.sendKeys(textbox, "Re", Keys.ENTER);
		

		return this;
	}



	public Boolean confirmAutoComplete(String[] expected_colors) {
		return false;
	}



}
