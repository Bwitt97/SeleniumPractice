package pages;

import static org.testng.Assert.expectThrows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.PageObjectBase;

public class ResultPage extends PageObjectBase {


	protected ResultPage(WebDriver driver, String url) {
		super(driver, url);
	}

	public ResultPage FilterBy(String text) {
		WebElement filter = this.getElement("//div[@id='container']/ytd-toggle-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]");
		filter.click();
		WebElement label = this.getElement(".//yt-formatted-string[contains(text(),'"+text+"')]");
		label.click();
		return this;
	}




}
