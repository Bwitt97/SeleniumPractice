package demoQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class CheckBoxPage extends PageObjectBase{

	private final String url = "checkbox";
	public CheckBoxPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public CheckBoxPage navigate()
	{
		this.navigate(url);
		return this;
	}


	public CheckBoxPage openDropdown() {
		WebElement dropdown = this.getElement("(.//*[normalize-space(text()) and normalize-space(.)='Book Store API'])[1]/following::*[name()='svg'][3]");
		this.WaitUntilClickable(dropdown);
		dropdown.click();
		return this;
	}

	public CheckBoxPage check(String[] check) {
		for(int i=0;i<check.length;i++)
		{
			WebElement checkbox= this.getElement(".//span[contains(text(),'"+check[i]+ "')]");
			this.WaitUntilClickable(checkbox);
			checkbox.click();
		}
		
		return this;
	}

	public Boolean[] checkStatus(String[] options) {
		Boolean[] status = {false,false,false};
		for(int i=0;i<options.length;i++)
		{
			String xpath = ".//label[@for='tree-node-"+options[i].toLowerCase()+"']//*[local-name()='svg']";
			WebElement box = this.getElement(xpath);
			System.out.print(box.getAttribute("class")+"\n");
			if(box.getAttribute("class").equals("rct-icon rct-icon-check"))
				status[i]=true;
			
		}
		
		
		
		return status;
	}

}
