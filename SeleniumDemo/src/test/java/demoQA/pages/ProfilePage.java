package demoQA.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class ProfilePage extends PageObjectBase {

	private final String url = "profile";
	public ProfilePage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public boolean confirmLogin() {
		return this.getDriver().findElement(By.id("userName-value")).isDisplayed();
	}

	public BookStorePage bookStore() {
		WebElement bookstore = this.getDriver().findElement(By.id("gotoStore"));
		this.WaitUntilClickable(bookstore);
		this.ScrollElementIntoView(bookstore);
		bookstore.click();
		return new BookStorePage(this.getDriver(),this.getBaseUrl());
	}

	public boolean confirmBookAddedThenRemove(String title) {
		try {
			WebElement book = this.getDriver().findElement(By.id("see-book-"+title));
			this.WaitUntilClickable(book);
			this.ScrollElementIntoView(book);
			
			
		}catch(NoSuchElementException e)
		{
			return false;
		}
		
		
		this.deleteTitleByIndex(title);
		return true;
	}

	public ProfilePage navigate() {
		this.navigate(url);
		return this;
	}

	
	public String printAll(String string) {
		List<WebElement> header_elements = this.getDriver().findElements(By.xpath(".//div[@class='rt-resizable-header-content']"));
		int index=1;
		String output="";
		for(WebElement e: header_elements) {
			
			if(e.getAttribute("innerHTML").equals(string))
				break;
			index++;
			
			if(index>header_elements.size())
			{
				System.out.print("Bogus input. Invalid");
				return "";
			}
		}
		
		List<WebElement> cells = this.getDriver().findElements(By.xpath(".//div[@role='gridcell']["+index+"]"));
		String whitespace ="<span>&nbsp;</span>";
		System.out.println(string);
		for(WebElement cell: cells)
		{
			String value =cell.getAttribute("innerHTML");
			if(value.equals(whitespace))
				break;
			else {
				System.out.println(value);
				output=output+value;
			}
			
		}
				
		return output;
	}
	
public ProfilePage printTable() {
		
		int row_num = this.getDriver().findElements(By.xpath(".//div[@role='rowgroup']")).size();
		int column_num=this.getDriver().findElements(By.xpath(".//div[@class='rt-resizable-header-content']")).size();
		List<WebElement> Cells= this.getDriver().findElements(By.xpath(".//div[@role='gridcell']"));
		String whitespace ="<span>&nbsp;</span>";
		for (WebElement e : Cells) {
			String value= e.getAttribute("innerHTML");
			
			if(value.equals(whitespace))
				break;
			else if(value.contains("delete-record-undefined"))
				System.out.print("Delete \n");
			else
				System.out.print(value+" ");
			
		}
	
		return this;
	}

public int getTitleIndex(String title) {
	
	int position = 1;
	List<WebElement> Cells= this.getDriver().findElements(By.xpath(".//div[@role='gridcell']"));
	String whitespace ="<span>&nbsp;</span>";
	for (WebElement e : Cells) {
		if(e.getAttribute("innerHTML").contains("delete-record-undefined"))
		{
			position+=1;
		}
		if(e.getAttribute("innerHTML").contains(title))
			break;
	}
	return position;
}

public ProfilePage deleteTitleByIndex(String title) {
	int position = 0;
	List<WebElement> Cells= this.getDriver().findElements(By.xpath(".//div[@role='gridcell']"));
	String whitespace ="<span>&nbsp;</span>";
	for (WebElement e : Cells) {
		if(e.getAttribute("innerHTML").contains("delete-record-undefined"))
		{
			position+=1;
		}
		if(e.getAttribute("innerHTML").contains(title))
			break;
	}
	List<WebElement> delete = this.getDriver().findElements(By.id("delete-record-undefined"));
	delete.get(position).click();

	try {
		WebElement ok = this.getDriver().findElement(By.id("closeSmallModal-ok"));
		this.WaitUntilClickable(ok);
		ok.click();
	}
	catch(NoSuchElementException e){
		System.err.println("*****NO ELEMENT DETECTED*****");
	}
	
	return this;
}
}
