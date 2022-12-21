package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class DatePickerPage extends PageObjectBase{
	private final String url = "date-picker";
	public DatePickerPage(WebDriver driver, String url) {
		super(driver, url);
		// TODO Auto-generated constructor stub
	}
	
	public DatePickerPage navigate() {
		this.navigate(url);
		return this;
	}
	

	public DatePickerPage enterSelectDateUsingInfo(String date) {
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



	public DatePickerPage enterSelectDateUsingValues(String month, String day, String year) {
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

}
