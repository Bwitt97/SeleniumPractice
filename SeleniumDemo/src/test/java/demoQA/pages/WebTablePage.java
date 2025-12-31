package demoQA.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class WebTablePage extends PageObjectBase{

	private final String url = "webtables";
	public WebTablePage(WebDriver driver, String url) {
		super(driver, url);
	}

	public WebTablePage navigate() {
		this.navigate(url);
		return this;
	}


	public WebTablePage printCatagoryHeaders() {
		List<WebElement> catagories =  this.getDriver().findElements(By.xpath(".//div[@class='rt-resizable-header-content']"));
		Iterator<WebElement> iter = catagories.iterator();
		
		while(iter.hasNext()){
			System.out.print(iter.next().getAttribute("innerHTML")+" ");
			
		}
		System.out.print("\n");
		return this;
	}

	public WebTablePage printTable() {
		
		int row_num = this.getDriver().findElements(By.xpath(".//div[@role='rowgroup']")).size();
		int column_num=this.getDriver().findElements(By.xpath(".//div[@class='rt-resizable-header-content']")).size();
		List<WebElement> Cells= this.getDriver().findElements(By.xpath(".//div[@role='gridcell']"));
		String whitespace ="<span>&nbsp;</span>";
		
		
		for (WebElement e : Cells) {
			String value= e.getAttribute("innerHTML");
			
			if(value.equals(whitespace))
				break;
			else if(value.contains("action-buttons"))
				System.out.print("Edit Delete \n");
			else
				System.out.print(value+" ");
		}
	
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
}
