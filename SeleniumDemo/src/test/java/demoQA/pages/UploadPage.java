package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class UploadPage extends PageObjectBase{
	private final String url = "upload-download";
	public UploadPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public UploadPage navigate() {
		this.navigate(url);
		return this;
	}
	
	public UploadPage uploadById(String string, String file) {
		WebElement upload = this.getDriver().findElement(By.id(string));
		this.WaitUntilClickable(upload);
		upload.sendKeys(file);
		return this;
	}

	public String getUploadFilePath() {
		return this.getDriver().findElement(By.id("uploadedFilePath")).getAttribute("innerText");
	}

}
