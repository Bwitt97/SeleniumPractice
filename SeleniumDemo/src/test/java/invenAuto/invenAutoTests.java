package invenAuto;

import org.testng.annotations.Test;

import invenAuto.pages.HomePage;

public class invenAutoTests extends invenAutoTestBase{
  @Test
  public void canReachWebPage() {
	  String url = new HomePage(this.getDriver(),this.getBaseUrl())
			  .navigate()
			  .getCurrenUrl();
  }
  @Test
  public void login()
  {
	  System.out.println(this.getUsername()+" "+this.getPassword());
	  String url = new HomePage(this.getDriver(),this.getBaseUrl())
			  .navigate()
			  .goToLogin()
			  .enterLoginInfo(this.getUsername(),this.getPassword())
			  .getCurrenUrl();
	  
	  System.err.println(url);
  }
}
