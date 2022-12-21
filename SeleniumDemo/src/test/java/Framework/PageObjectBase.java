package Framework;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class PageObjectBase {

	private WebDriver driver;
	private String base_url;

	
	protected PageObjectBase(WebDriver driver, String url)
	{
		this.driver=driver;
		this.base_url=url;
		PageFactory.initElements(driver, this);
	}
	
	public void setAttribute(String selector, String attribute, String value)  {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.querySelector('"+selector+"').setAttribute('"+attribute+"','"+value+"')");
	}
	public String getCurrenUrl()
	{
		return this.driver.getCurrentUrl();
	}
	
	protected WebDriver getDriver()
	{
		return this.driver;
	}
	
	protected String getBaseUrl()
	{
		return this.base_url;
	}
	
	public WebElement getElement(String xpath) {
		return this.getDriver().findElement(By.xpath(xpath));
	}
	protected void WaitUntilClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(this.getDriver(), 30);

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void ScrollElementIntoView(WebElement element) {
		((JavascriptExecutor) this.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	protected void activateNewTab() {
		Set<String> handles = getDriver().getWindowHandles();
		String lastHandle = Helpers.getLastElement(handles);

		getDriver().switchTo().window(lastHandle);			
	}

	protected void navigate(String url) {
		String fullUrl = this.getBaseUrl() + url;
		this.getDriver().navigate().to(fullUrl);		
	}

	public Boolean WaitUntilAttributeVisible(WebElement element, String attr)
	{
		try {
			WebDriverWait wait = new WebDriverWait(this.getDriver(),10);
			wait.until(new ExpectedCondition<Boolean>(){

				public Boolean apply(WebDriver driver) {
					String enabled = element.getAttribute("aria-describedby");
					if(enabled!=null)
						return true;
					else
						return false;
				}
				
			});}
			catch(TimeoutException e) {
				System.err.println("UNABLE TO LOCATE ATTRIBUTE");
				return false;
			}
		
		return true;
	}

}
