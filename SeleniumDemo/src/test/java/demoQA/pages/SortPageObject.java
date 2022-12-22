package demoQA.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Framework.PageObjectBase;

public class SortPageObject extends PageObjectBase{

	private final String url = "sortable";
	public SortPageObject(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public SortPageObject navigate()
	{
		this.navigate(url);
		return this;
	}

	public SortPageObject dragAndDropAfter(String dragObject, String loc) {
		Actions act = new Actions(this.getDriver());
		WebElement source = this.getDriver().findElement(By.xpath(".//div[contains(text(),'"+dragObject+"')]"));
		WebElement target = this.getDriver().findElement(By.xpath(".//div[contains(text(),'"+loc+"')]"));
		this.ScrollElementIntoView(target);
		act.dragAndDrop(source, target).perform();
		return this;
	}

	public String confirmOrder() {
		List<WebElement> sort = this.getDriver().findElements(By.xpath(".//div[@class='vertical-list-container mt-4']/div[@class='list-group-item list-group-item-action']"));
		String order = "";
	
		for(WebElement item : sort)
		{
			order=order+item.getAttribute("innerText");
		}
		
		System.out.println(order);
		return order;
	}

}
