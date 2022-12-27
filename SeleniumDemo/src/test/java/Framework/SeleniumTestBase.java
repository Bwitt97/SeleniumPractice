package Framework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
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
	private ChromeOptions options;
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
	public void setup()
	{
		loadsettings();
		launchbrowser();
	}
	
	public String getUsername(){
		return this.settings.username;
	}
	
	public String getPassword(){
		return this.settings.password;
	}
	public String getBookstorePassword() {
		return this.settings.bookstore_password;
	}
	public void launchbrowser()
	{
	
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
        this.options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\brand\\eclipse-workspace\\SeleniumDemo\\src\\test\\resources\\1.45.2_0.crx"));
        options.setBinary(new File("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"));
        this.driver=new ChromeDriver(options);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}
	

	@AfterMethod
	public void close() {
		this.getDriver().quit();
	}
}
