package demoQA.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.PageObjectBase;

public class ElementsPage extends PageObjectBase{

	protected ElementsPage(WebDriver driver, String url) {
		super(driver, url);
	}

	

	public ElementsPage EnterCredentials() {
		WebElement fullname = this.getElement(".//input[@id='userName']");
		WebElement email = this.getElement(".//input[@id='userEmail']");
		WebElement address = this.getElement(".//textarea[@id='currentAddress']");
		WebElement perm_address = this.getElement(".//textarea[@id='permanentAddress']");
		
		fullname.sendKeys("Brandon Witt");
		email.sendKeys("brandonwitt@email.com");
		address.sendKeys("Address nw 29th ave");
		perm_address.sendKeys("Address apt 10 nw 22070");
		
		WebElement submit_btn=this.getElement(".//button[@id='submit']");
		this.ScrollElementIntoView(submit_btn);
		this.WaitUntilClickable(submit_btn);

		submit_btn.click();
		
		return this;
	}

	public Boolean outputIsVisible() {
		if(this.getElement(".//div[@id='output']") != null)
			return true;
		else
			return false;
		
	}



	public ElementsPage openDropdown() {
		WebElement dropdown = this.getElement("(.//*[normalize-space(text()) and normalize-space(.)='Book Store API'])[1]/following::*[name()='svg'][3]");
		this.WaitUntilClickable(dropdown);
		dropdown.click();
		return this;
	}

	public ElementsPage check(String[] check) {
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


	public ElementsPage selectbylabel(String string) {
		WebElement btn = this.getElement(".//label[@for='"+string+"']");
		this.WaitUntilClickable(btn);
		btn.click();
		return this;
	}

	public String radiobutton_status() {
		return this.getElement(".//span[@class='text-success']").getAttribute("innerHTML");
	}


	public ElementsPage printCatagoryHeaders() {
		List<WebElement> catagories =  this.getDriver().findElements(By.xpath(".//div[@class='rt-resizable-header-content']"));
		Iterator<WebElement> iter = catagories.iterator();
		
		while(iter.hasNext()){
			System.out.print(iter.next().getAttribute("innerHTML")+" ");
			
		}
		System.out.print("\n");
		return this;
	}

	public ElementsPage printTable() {
		
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

	public ElementsPage buttons() {
		WebElement buttons_tab = this.getElement(".//span[contains(text(),'Buttons')]");
		this.WaitUntilClickable(buttons_tab);
		buttons_tab.click();
		return this;
	}

	public ElementsPage doubleClick(String string) {
		WebElement btn=this.getElement(".//button[@id='"+string+"']");
		this.WaitUntilClickable(btn);
		new Actions(this.getDriver()).doubleClick(btn).perform();
		return this;
	}

	public ElementsPage rightClick(String string) {
		WebElement btn=this.getElement(".//button[@id='"+string+"']");
		this.WaitUntilClickable(btn);
		new Actions(this.getDriver()).contextClick(btn).perform();
		return this;
	}

	public Boolean assertButtonPrompts() {
		return false;
	}

	public ElementsPage SelectTab(String string) {
		WebElement tab = this.getElement(".//span[contains(text(),'"+string+"')]");
		this.ScrollElementIntoView(tab);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.WaitUntilClickable(tab);
		tab.click();
		return this;
	}



	public ElementsPage clickButtonByClass(String string) {
		WebElement btn = this.getElement(".//button[@class='"+string+"']");
		this.WaitUntilClickable(btn);
		btn.click();
		return this;
	}



	public PageObjectBase selectById(String string) {
		WebElement btn = this.getDriver().findElement(By.id(string));
		this.WaitUntilClickable(btn);
		btn.click();
		return this;
	}



	public ElementsPage clickButtonByIndex(int i) {
		List<WebElement> btns = this.getDriver().findElements(By.xpath(".//button[@class='btn btn-primary']"));
		
		btns.get(i).click();
		
		return this;
	}



	public PageObjectBase selectLinkById(String string) {
		WebElement link = this.getDriver().findElement(By.id(string));
		this.WaitUntilClickable(link);
		link.click();
		this.activateNewTab();
		return this;
	}



	public Boolean checkForBrokenImage() throws IOException {
		List<WebElement> images = this.getDriver().findElements(By.tagName("img"));
		for(WebElement img : images) {
			String imageSrc = img.getAttribute("src");
			try {
			URL url = new URL(imageSrc);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
			
			if(httpURLConnection.getResponseCode()==200)
			{
				System.out.println(imageSrc + ">>" + httpURLConnection.getResponseCode()+">>"+" OK");
			}
			else
			{
				System.err.println(imageSrc + ">>" + httpURLConnection.getResponseCode()+">>"+"Not found");
				return false;
			}
			httpURLConnection.disconnect();}
			catch(Exception e){
				System.err.println(imageSrc);
			}
		}
		return true;
	}



	public ElementsPage uploadById(String string, String file) {
		WebElement upload = this.getDriver().findElement(By.id(string));
		this.WaitUntilClickable(upload);
		upload.sendKeys(file);
		
		return this;
	}



	public String getButtonTextById(String string) {
		WebElement btn = this.getDriver().findElement(By.id(string));
		
		return btn.getAttribute("innerHTML");
	}



	public ElementsPage printTextIdByXpath(String string) {
		WebElement text = this.getElement(string);
		System.out.print(text.getAttribute("id"));
		return this;
	}


	public ElementsPage selectCatagory(String catagory) {
		WebElement element = this.getElement(".//div[contains(text(),'"+catagory+"')]");
		this.ScrollElementIntoView(element);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.WaitUntilClickable(element);
		element.click();
		return this;
	}




	public ElementsPage RegisterStudent(String[] userInfo) {
		WebElement firstname = this.getDriver().findElement(By.id("firstName"));
		WebElement lastname = this.getDriver().findElement(By.id("lastName"));
		WebElement email = this.getDriver().findElement(By.id("userEmail"));
		WebElement gender = this.getDriver().findElement(By.xpath(".//label[contains(text(),'"+userInfo[3]+"')]"));
		WebElement number = this.getDriver().findElement(By.id("userNumber"));
		WebElement birth = this.getDriver().findElement(By.id("dateOfBirthInput"));
		//WebElement subject = this.getDriver().findElement(By.id("subjectsContainer"));
		WebElement hobby = this.getDriver().findElement(By.xpath(".//label[contains(text(),'"+userInfo[7]+"')]"));
		WebElement upload = this.getDriver().findElement(By.id("uploadPicture"));
		WebElement address = this.getDriver().findElement(By.id("currentAddress"));
		WebElement state = this.getDriver().findElement(By.id("state"));
		WebElement city = this.getDriver().findElement(By.id("city"));
		
		
		
		firstname.sendKeys(userInfo[0]);
		lastname.sendKeys(userInfo[1]);
		email.sendKeys(userInfo[2]);
		this.WaitUntilClickable(gender);
		gender.click();
		number.sendKeys(userInfo[4]);
		birth.sendKeys(userInfo[5],Keys.ENTER);
		//subject.sendKeys(userInfo[6]);
		this.ScrollElementIntoView(hobby);
		this.WaitUntilClickable(hobby);
		hobby.click();
		this.ScrollElementIntoView(upload);
		upload.sendKeys(userInfo[8]);
		this.ScrollElementIntoView(state);
		address.sendKeys(userInfo[9]);
		//state.click();
		//cannot pick state or submit because adds are in the way
		//report bug
		
		return this;
	}



	public ElementsPage clickButtonById(String string) {
		WebElement btn = this.getDriver().findElement(By.id(string));
		btn.click();
		return this;
	}
	
	public ElementsPage activateTab()
	{
		this.activateNewTab();
		return this;
	}



	public Boolean checkForAlert() {
		int i=0;
		while(i++<10)
		{
			try {
				Alert alert = this.getDriver().switchTo().alert();
				alert.accept();
				break;
			}
			catch(NoAlertPresentException e){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				continue;
			}
		}
		if(i>=10)
			return false;
		return true;
	}



	public Boolean alertOk() {
		
		try {
			Alert alert = this.getDriver().switchTo().alert();
			alert.accept();
		}
		catch(NoAlertPresentException e){
			System.err.println("*****NO ALERT MESSAGE DETECTED*****");
			return false;
		}
		
		return true;
	}



	public ElementsPage alertSendKeys(String string) {
		try {
			Alert alert = this.getDriver().switchTo().alert();
			alert.sendKeys(string);
			alert.accept();
		}
		catch(NoAlertPresentException e){
			System.err.println("*****NO ALERT MESSAGE DETECTED*****");
			return this;
		}
		
		

		return this;
	}



	public String getPrompt() {
		return this.getDriver().findElement(By.id("promptResult")).getAttribute("innerHTML");
	}



	public ElementsPage switchToFrame(String string) {
		WebElement frame = this.getDriver().findElement(By.id(string));
		this.getDriver().switchTo().frame(frame);
		return this;
	}



	public String getH1TextById(String string) {
		return this.getDriver().findElement(By.id(string)).getAttribute("innerHTML");
	}



	public String getAllTextFromBody() {
		return this.getDriver().findElement(By.tagName("body")).getAttribute("innerText");
	}



	public ElementsPage switchToFrameByXpath(String xpath) {
		this.getDriver().switchTo().frame(this.getElement(xpath));
		return this;
	}



	public String getAllTextFromP() {
		return this.getDriver().findElement(By.tagName("p")).getAttribute("innerText");

	}



	public String getModelTextById(String string) {
		return this.getDriver().findElement(By.id(string)).getAttribute("innerText");
	}



	public ElementsPage clickById(String string) {
		WebElement element =this.getDriver().findElement(By.id(string));
		this.WaitUntilClickable(element);
		element.click();
		return this;
	}



	public Boolean confirmVisable(String string) {
		WebElement block = this.getDriver().findElement(By.id(string));
		if(block.isDisplayed())
			return true;
		else
			return false;
	}



	public ElementsPage enterMultipleColorsById(String[] autofill_colors,String id) {
		String xpath = ".//div[@id='"+id+"']/div/div";
		Actions act = new Actions(this.getDriver());
		WebElement textbox = this.getDriver().findElement(By.xpath(xpath));
		this.ScrollElementIntoView(textbox);
		this.WaitUntilClickable(textbox);
		textbox.click();
		act.sendKeys(textbox, "Re", Keys.ENTER);
		

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}



	public Boolean confirmAutoComplete(String[] expected_colors) {
		return false;
	}



	public ElementsPage enterSelectDateUsingInfo(String date) {
		WebElement select_date = this.getDriver().findElement(By.id("datePickerMonthYearInput"));
		this.WaitUntilClickable(select_date);
		select_date.sendKeys(Keys.CONTROL+"a");
		select_date.sendKeys(Keys.DELETE);
		select_date.sendKeys(date);
		select_date.sendKeys(Keys.ENTER);
		return this;
	}



	public Boolean confirmSelectDateEntered(String birthday) {
		String date_value = this.getDriver().findElement(By.id("datePickerMonthYearInput")).getAttribute("value");
		
		if(date_value.equals(birthday))
			 return true;
		else
			return false;
	}



	public ElementsPage enterSelectDateUsingValues(String month, String day, String year) {
		//Fix day int
		while(day.length()<3)
			day="0".concat(day);
		
		WebElement select_date = this.getDriver().findElement(By.id("datePickerMonthYearInput"));
		this.WaitUntilClickable(select_date);
		select_date.click();
		
		
		WebElement select_month=this.getDriver().findElement(By.className("react-datepicker__month-select"));
		select_month.click();
		select_month.sendKeys(month);
		select_month.sendKeys(Keys.ENTER);
		
		WebElement select_year=this.getDriver().findElement(By.className("react-datepicker__year-select"));
		select_year.click();
		select_year.sendKeys(year);
		select_year.sendKeys(Keys.ENTER);
		

		
		
		try {
			WebElement select_day=this.getDriver().findElement(By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--"+day+"']"));
			select_day.click();
		}
		catch(NoSuchElementException e) {
			System.err.println("Day already set to correct value");
		}
		
	
		return this;
	}



	public boolean sliderToValuesAndConfirm(int[] values) {
		WebElement slider = this.getDriver().findElement(By.xpath(".//input[@class='range-slider range-slider--primary']"));
		Actions slide = new Actions(this.getDriver());
		for(int num : values) {
			int scalar = 255*((num-50)*2)/100;
			Actions action = slide.dragAndDropBy(slider,scalar,0);
			action.perform();
			System.out.println(slider.getAttribute("value"));
			if(String.valueOf(num).equals(slider.getAttribute("value"))==false)
				return false;
		}
		return true;
	}



	public ElementsPage stopAtValue(String string) {
		WebElement startStop_btn=this.getDriver().findElement(By.id("startStopButton"));
		WebElement progress=this.getDriver().findElement(By.xpath(".//div[@class='progress-bar bg-info']"));
		String value = progress.getAttribute("aria-valuenow");
		startStop_btn.click();
		while(Integer.parseInt(value)<100)
		{
		    value = progress.getAttribute("aria-valuenow");
			if(value.equals(string)) {
				startStop_btn.click();
				break;}

		}
		return this;
	}



	public String getValueOfProgressBar() {
		return this.getDriver().findElement(By.xpath(".//div[@class='progress-bar bg-info']")).getAttribute("aria-valuenow");
	}



	public Boolean checkIfActive(String string) {
		WebElement element = this.getDriver().findElement(By.id(string));
		if(element.getAttribute("class").equals("nav-item nav-link active"))
			return true;
		else
			return false;
		
	}






	
	

}
