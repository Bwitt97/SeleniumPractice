package youtube;

import org.testng.annotations.Test;

import pages.HomePageObject;

public class youtubeTests extends youtubeTestBase{

@Test
  public void LaunchHomePage() {
String url = new HomePageObject(this.getDriver(),this.getBaseUrl())
.navigate()
.getCurrenUrl();
  }

@Test 
public void Reachlogin() {
	String url= new HomePageObject(this.getDriver(),this.getBaseUrl())
			.navigate()
			.loginPage()
			.getCurrenUrl();
}
@Test
public void EnterTextAndSearch() {
	String url= new HomePageObject(this.getDriver(),this.getBaseUrl())
			.navigate()
			.search("Mr beast")
			.getCurrenUrl();
	
}
@Test
public void FitlerTest() {
	String url = new HomePageObject(this.getDriver(),this.getBaseUrl())
			.navigate()
			.search("Mr Beast")
			.FilterBy("Channel")
			.getCurrenUrl();
}
}
