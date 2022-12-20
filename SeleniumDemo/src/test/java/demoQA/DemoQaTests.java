package demoQA;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import demoQA.pages.HomePage;

public class DemoQaTests extends DemoQATestBase{


	@Test
	public void canStartDriver() 
	{
		String url = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.getCurrenUrl();
	}
	@Test
	public void EnterTestBoxAndSubmit() {
		
		Boolean output= new HomePage(this.getDriver(), this.getBaseUrl())
				.navigate()
				.elements()
				.SelectTab("Text Box")
				.EnterCredentials()
				.outputIsVisible();
		
		assertEquals(true, output, "The output should be displayed");
		
	}
	@Test
	public void selectCheckBox() {
		String[] options = {"Desktop","Documents","Downloads"};
		String[] check = {"Documents","Downloads"};
		String[] uncheck = {"Documents"};
		Boolean[] expected_status= {false,false,true};
		Boolean[] output = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.SelectTab("Check Box")
				.openDropdown()
				.check(check)
				.check(uncheck)
				.checkStatus(options);
		
		assertEquals(output, expected_status, "the output should match the expected values of the check boxes");
	}
	
	@Test
	public void CanSelectRadioButton()
	{
		String output = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.SelectTab("Radio Button")
				.selectbylabel("yesRadio")
				.selectbylabel("impressiveRadio")
				.selectbylabel("noRadio")
				.radiobutton_status();
		
		assertEquals(output, "Impressive", "the text should say impressive, because No is not clickable");
	}
	
	@Test
	public void SearchIndexInWebTable() {
		String expected = "CierraAldenKierra";
		String output = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.SelectTab("Web Tables")
				.printCatagoryHeaders()
				.printTable()
				.printAll("First Name");
		assertEquals(output, expected, "Should have printed all first names");
				}
	
	@Test
	public void CanClickButtons()
	{
		Boolean output = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.SelectTab("Buttons")
				.doubleClick("doubleClickBtn")
				.rightClick("rightClickBtn")
				.clickButtonByIndex(2)
				.assertButtonPrompts();
	}
	
	@Test
	public void canClickHyperlinks()
	{
		String expected = this.base_url;
		String url = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.SelectTab("Links")
				.selectLinkById("simpleLink")
				.getCurrenUrl();
		
		assertEquals(url,expected, "we should be on the home page");
	}
	@Test
	public void findBrokenImage() throws IOException
	{
		Boolean image=new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.SelectTab("Images")
				.checkForBrokenImage();
		
		assertTrue(image);
	}
	
	@Test
	public void uploadFile() {
		String file_path = "C:\\Users\\brand\\eclipse-workspace\\SeleniumDemo\\src\\test\\resources\\config.properties";
		
		String url = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.SelectTab("Upload and Download")
				.uploadById("uploadFile",file_path)
				.getCurrenUrl();
	}
	
	@Test
	public void DynamicProperties() {
		
		String expected = "Visible After 5 Seconds";
		String btn_text = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.SelectTab("Dynamic Properties")
				.printTextIdByXpath(".//div/div/p")
				.getButtonTextById("visibleAfter");
		
		assertEquals(btn_text,expected, "The text should be equal");
		
	}
	
	@Test
	public void PracticeForm()
	{
		String file_path = "C:\\Users\\brand\\eclipse-workspace\\SeleniumDemo\\src\\test\\resources\\config.properties";

		String[] userInfo = {"Brandon","Witt","bwitt@mail.com","Male","1234567890","19 Sep 1997","Subject","Music",file_path,"ADDRESS 20 AVE",
				"Haryana","Karnal"};
		String url = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Forms")
				.SelectTab("Practice Form")
				.RegisterStudent(userInfo)
				.getCurrenUrl();
	}
	
	@Test
	public void CheckForNewTab()
	{
		String expected = "https://demoqa.com/sample";
		String url = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Alerts, Frame & Windows")
				.SelectTab("Browser Windows")
				.clickButtonById("tabButton")
				.activateTab()
				.getCurrenUrl();
		assertEquals(url, expected, "THE STRINGS SHOULD MATCH");
	}
	@Test
	public void CheckForNewWindow()
	{
		String expected = "https://demoqa.com/sample";
		
		String url = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Alerts, Frame & Windows")
				.SelectTab("Browser Windows")
				.clickButtonById("windowButton")
				.activateTab()
				.getCurrenUrl();
		
		assertEquals(url, expected, "THE STRINGS SHOULD MATCH");

	}
	
	@Test
	public void CheckForAlert()
	{
		Boolean present = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Alerts, Frame & Windows")
				.SelectTab("Alerts")
				.clickButtonById("alertButton")
				.checkForAlert();
		
		assertTrue(present);
	}
	
	@Test
	public void checkForDelayedAlert()
	{
		Boolean present = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Alerts, Frame & Windows")
				.SelectTab("Alerts")
				.clickButtonById("timerAlertButton")
				.checkForAlert();
		
		assertTrue(present);
	}
	
	@Test
	public void pressOkBox()
	{
		Boolean present = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Alerts, Frame & Windows")
				.SelectTab("Alerts")
				.clickButtonById("confirmButton")
				.alertOk();
	}
	
	@Test
	public void enterTextintoAlert() 
	{
		String expected = "Sendable Keys";
		String result = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Alerts, Frame & Windows")
				.SelectTab("Alerts")
				.clickButtonById("promtButton")
				.alertSendKeys(expected)
				.getPrompt();
		
		assertEquals(result, "You entered "+expected, "they should match");
		
	}
	
	@Test
	public void iFrameTesting()
	{
		String expected = "This is a sample page";
		String heading = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Alerts, Frame & Windows")
				.SelectTab("Frames")
				.switchToFrame("frame1")
				.getH1TextById("sampleHeading");
		assertEquals(heading,expected, "The text should match");
		
	}
	
	@Test
	public void iFrameTesting2()
	{
		String expected = "This is a sample page";
		String heading = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Alerts, Frame & Windows")
				.SelectTab("Frames")
				.switchToFrame("frame2")
				.getH1TextById("sampleHeading");
		assertEquals(heading,expected, "The text should match");
	}
	
	@Test
	public void nestedFrameTest()
	{
		String parent = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Alerts, Frame & Windows")
				.SelectTab("Nested Frames")
				.switchToFrame("frame1")
				.getAllTextFromBody();
		assertEquals(parent,"Parent frame", "the strings should match");
		
		String xpath= ".//body/iframe";
		String child = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Alerts, Frame & Windows")
				.SelectTab("Nested Frames")
				.switchToFrame("frame1")
				.switchToFrameByXpath(xpath)
				.getAllTextFromP();
		assertEquals(child,"Child Iframe", "the strings should match");
	}
	@Test
	public void modelDialogTest()
	{
		String expected = "Small Modal";
		String text = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Alerts, Frame & Windows")
				.SelectTab("Modal Dialogs")
				.clickButtonById("showSmallModal")
				.getModelTextById("example-modal-sizes-title-sm");
		
		assertEquals(text,expected, "should match");
		
		 expected = "Large Modal";
		 text = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Alerts, Frame & Windows")
				.SelectTab("Modal Dialogs")
				.clickButtonById("showLargeModal")
				.getModelTextById("example-modal-sizes-title-lg");
		
		assertEquals(text,expected, "should match");
		
		
	}
	
	@Test
	public void canOpenAccordianWidget()
	{
		Boolean visible = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Widgets")
				.SelectTab("Accordian")
				.clickById("section1Heading")
				.confirmVisable("section1Content");
		
		assertTrue(visible);
		
		
	
		visible = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Widgets")
				.SelectTab("Accordian")
				.clickById("section2Heading")
				.confirmVisable("section2Content");	
		assertTrue(visible);
		
		visible = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Widgets")
				.SelectTab("Accordian")
				.clickById("section3Heading")
				.confirmVisable("section3Content");
		assertTrue(visible);
		
		
				
				
				
	}
	
	//Bugged, Text box is not interactable and cannot have keys sent
	public void autofillTest() {
		String[] autofill_colors = {"R","Bl","Gre"};
		String[] expected_colors = {"Red","Blue","Green"};
		
		Boolean confirm = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Widgets")
				.SelectTab("Auto Complete")
				.enterMultipleColorsById(autofill_colors,"autoCompleteMultipleContainer")
				.confirmAutoComplete(expected_colors);
				
	}
	@Test
	public void selectDateUsingStringValue() {
		String birthday = "09/19/1997";
		Boolean date = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Widgets")
				.SelectTab("Date Picker")
				.enterSelectDateUsingInfo(birthday)
				.confirmSelectDateEntered(birthday);
	assertTrue(date);
	}
	
	@Test
	public void selectDateUsingMultipleValues() {
		String month = "September";
		String day = "19";
		String year = "1997";
		String expected = "09/19/1997";
		
		Boolean date = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Widgets")
				.SelectTab("Date Picker")
				.enterSelectDateUsingValues(month,day,year)
				.confirmSelectDateEntered(expected);
		
		assertTrue(date);
	}
	
	@Test
	public void sliderTest() {
		int[] values = {50,30,20,80};
		boolean slider = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Widgets")
				.SelectTab("Slider")
				.sliderToValuesAndConfirm(values);
		
		assertTrue(slider);
				
	}
	
	@Test
	public void progressBar()
	{
		String expected = "70";
		String value = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Widgets")
				.SelectTab("Progress Bar")
				.stopAtValue(expected)
				.getValueOfProgressBar();
		
		assertEquals(value,expected,"Values should match");
	}
	
	@Test
	public void switchTab() {
		
		Boolean tab = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.elements()
				.selectCatagory("Widgets")
				.SelectTab("Tabs")
				.clickById("demo-tab-origin")
				.checkIfActive("demo-tab-origin");
	}
	
	
}
