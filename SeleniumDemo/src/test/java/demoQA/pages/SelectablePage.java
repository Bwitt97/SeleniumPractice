package demoQA.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class SelectablePage extends PageObjectBase{
	private final String url = "selectable";
	public SelectablePage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public SelectablePage navigate() {
		this.navigate(url);
		return this;
	}
	
	public SelectablePage clickById(String id) {
		WebElement element = this.getDriver().findElement(By.id(id));
		this.WaitUntilClickable(element);
		element.click();
		return this;
	}

	public SelectablePage clickLiByInnerText(String string) {
		WebElement element = this.getDriver().findElement(By.xpath(".//li[contains(text(),'"+string+"')]"));
		this.WaitUntilClickable(element);
		this.ScrollElementIntoView(element);
		element.click();
		return this;
	}

	public String getSelectedValues() {
		List<WebElement> selected = this.getDriver().findElements(By.xpath(".//li[@class='list-group-item active list-group-item-action']"));
		String order = "";
	
		for(WebElement item : selected)
		{
			order=order+item.getAttribute("innerText");
		}
		
		System.out.println(order);
		return order;
	}
	
	

}
