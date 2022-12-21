package demoQA.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class ImagePage extends PageObjectBase{
	private final String url = "broken";
	public ImagePage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public ImagePage navigate() {
		this.navigate(url);
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
}
