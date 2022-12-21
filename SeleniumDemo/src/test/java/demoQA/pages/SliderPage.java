package demoQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Framework.PageObjectBase;

public class SliderPage extends PageObjectBase{
	private final String url = "slider";
	public SliderPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public SliderPage navigate() {
		this.navigate(url);
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

}
