package Framework;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Framework.ConfigFile;

public abstract class SeleniumTestBase {

	
	private Setting settings;
	private WebDriver driver;
	private final String filename="config.properties";
	protected String base_url;
	
	public SeleniumTestBase(String url) {
		this.base_url=url;	
	}
	

	public WebDriver getDriver()
	{
		return this.driver;
	}
	
	public String getBaseUrl() {
		return this.base_url;
	}
	public Setting getSettings()
	{
		return this.settings;
	}
	
	public void loadsettings()
	{
		HashMap<String,String> properties = new ConfigFile().getPropertiesFromResourceFile(filename);
		this.settings=new Setting(properties);
	}
	@BeforeMethod
	public void launchbrowser()
	{
	
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
		this.driver=new ChromeDriver();
		this.driver.navigate().to("https://google.com");
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}
	
	public void setup()
	{
		loadsettings();
		launchbrowser();
	}
	@AfterMethod
	public void close() {
		this.getDriver().quit();
	}
}
