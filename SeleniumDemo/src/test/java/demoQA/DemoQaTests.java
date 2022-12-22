package demoQA;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import demoQA.pages.AccordianPage;
import demoQA.pages.AlertPage;
import demoQA.pages.BrowserWindowsPage;
import demoQA.pages.ButtonsPage;
import demoQA.pages.CheckBoxPage;
import demoQA.pages.DatePickerPage;
import demoQA.pages.DialogPage;
import demoQA.pages.DroppablePage;
import demoQA.pages.DynamicPropertiesPage;
import demoQA.pages.FramesPage;
import demoQA.pages.HomePage;
import demoQA.pages.ImagePage;
import demoQA.pages.LinksPage;
import demoQA.pages.MenuPage;
import demoQA.pages.NestedFramesPage;
import demoQA.pages.PracticeFormPage;
import demoQA.pages.ProgressBarPage;
import demoQA.pages.RadioButtonPage;
import demoQA.pages.ResizablePage;
import demoQA.pages.SelectMenuPage;
import demoQA.pages.SelectablePage;
import demoQA.pages.SliderPage;
import demoQA.pages.SortPageObject;
import demoQA.pages.TabsPage;
import demoQA.pages.TextBoxPage;
import demoQA.pages.ToolTipsPage;
import demoQA.pages.UploadPage;
import demoQA.pages.WebTablePage;
import demoQA.pages.autofillPage;

public class DemoQaTests extends DemoQATestBase{


	@Test
	public void canReachHomePage() 
	{
		String url = new HomePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.getCurrenUrl();
	}
	@Test
	public void EnterTestBoxAndSubmit() {
		
		Boolean output= new TextBoxPage(this.getDriver(), this.getBaseUrl())
				.navigate()
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
		Boolean[] output = new CheckBoxPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.openDropdown()
				.check(check)
				.check(uncheck)
				.checkStatus(options);
		
		assertEquals(output, expected_status, "the output should match the expected values of the check boxes");
	}
	
	@Test
	public void CanSelectRadioButton()
	{
		String output = new RadioButtonPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.selectbylabel("yesRadio")
				.selectbylabel("impressiveRadio")
				.selectbylabel("noRadio")
				.radiobutton_status();
		
		assertEquals(output, "Impressive", "the text should say impressive, because No is not clickable");
	}
	
	@Test
	public void SearchIndexInWebTable() {
		String expected = "CierraAldenKierra";
		String output = new WebTablePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.printCatagoryHeaders()
				.printTable()
				.printAll("First Name");
		assertEquals(output, expected, "Should have printed all first names");
				}
	
	@Test
	public void CanClickButtons()
	{
		Boolean output = new ButtonsPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.doubleClick("doubleClickBtn")
				.rightClick("rightClickBtn")
				.clickButtonByIndex(2)
				.assertButtonPrompts();
		
		assertTrue(output);
	}
	
	@Test
	public void canClickHyperlinks()
	{
		String expected = this.base_url;
		String url = new LinksPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.selectLinkById("simpleLink")
				.getCurrenUrl();
		
		assertEquals(url,expected, "we should be on the home page");
	}
	@Test
	public void findBrokenImage() throws IOException
	{
		//the code is correct, however the image on the page isn't broken. It is supposed to look like that, so the test cannot find a "broken" image
		Boolean image=new ImagePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.checkForBrokenImage();
		
		assertTrue(image);
	}
	
	@Test
	public void uploadFile() {
		String file_path = "C:\\Users\\brand\\eclipse-workspace\\SeleniumDemo\\src\\test\\resources\\config.properties";
		String expected = "C:\\fakepath\\config.properties";
		String path = new UploadPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.uploadById("uploadFile",file_path)
				.getUploadFilePath();
		
		assertEquals(path,expected,"they should be the same file path");
	}
	
	@Test
	public void DynamicProperties() {
		
		String expected = "Visible After 5 Seconds";
		String btn_text = new DynamicPropertiesPage(this.getDriver(),this.getBaseUrl())
				.navigate()
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
		String url = new PracticeFormPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.RegisterStudent(userInfo)
				.getCurrenUrl();
		//test cannot be finished, An ad is in the way of the submit button. 
	}
	
	@Test
	public void CheckForNewTab()
	{
		String expected = "https://demoqa.com/sample";
		String url = new BrowserWindowsPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.clickButtonById("tabButton")
				.activateTab()
				.getCurrenUrl();
		assertEquals(url, expected, "THE STRINGS SHOULD MATCH");
	}
	@Test
	public void CheckForNewWindow()
	{
		String expected = "https://demoqa.com/sample";
		
		String url = new BrowserWindowsPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.clickButtonById("windowButton")
				.activateTab()
				.getCurrenUrl();
		
		assertEquals(url, expected, "THE STRINGS SHOULD MATCH");

	}
	
	@Test
	public void CheckForAlert()
	{
		Boolean present = new AlertPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.clickButtonById("alertButton")
				.checkForAlert();
		
		assertTrue(present);
	}
	
	@Test
	public void checkForDelayedAlert()
	{
		Boolean present = new AlertPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.clickButtonById("timerAlertButton")
				.checkForAlert();
		
		assertTrue(present);
	}
	
	@Test
	public void pressOkBox()
	{
		Boolean present = new AlertPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.clickButtonById("confirmButton")
				.alertOk();
	}
	
	@Test
	public void enterTextintoAlert() 
	{
		String expected = "Sendable Keys";
		String result = new AlertPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.clickButtonById("promtButton")
				.alertSendKeys(expected)
				.getPrompt();
		
		assertEquals(result, "You entered "+expected, "they should match");
		
	}
	
	@Test
	public void iFrameTesting()
	{
		String expected = "This is a sample page";
		String heading = new FramesPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.switchToFrame("frame1")
				.getH1TextById("sampleHeading");
		assertEquals(heading,expected, "The text should match");
		
	}
	
	@Test
	public void iFrameTesting2()
	{
		String expected = "This is a sample page";
		String heading = new FramesPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.switchToFrame("frame2")
				.getH1TextById("sampleHeading");
		assertEquals(heading,expected, "The text should match");
	}
	
	@Test
	public void nestedFrameTest()
	{
		String parent = new NestedFramesPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.switchToFrame("frame1")
				.getAllTextFromBody();
		assertEquals(parent,"Parent frame", "the strings should match");
		
		String xpath= ".//body/iframe";
		String child = new NestedFramesPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.switchToFrame("frame1")
				.switchToFrameByXpath(xpath)
				.getAllTextFromP();
		assertEquals(child,"Child Iframe", "the strings should match");
	}
	@Test
	public void modelDialogTest()
	{
		String expected = "Small Modal";
		String text = new DialogPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.clickById("showSmallModal")
				.getModelTextById("example-modal-sizes-title-sm");
		
		assertEquals(text,expected, "should match");
		
		 expected = "Large Modal";
		 text = new DialogPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.clickById("showLargeModal")
				.getModelTextById("example-modal-sizes-title-lg");
		
		assertEquals(text,expected, "should match");
		
		
	}
	
	@Test
	public void canOpenAccordianWidget()
	{
		Boolean visible = new AccordianPage(this.getDriver(),this.getBaseUrl())
				.navigate()
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
	//skip test
	public void autofillTest() {
		String[] autofill_colors = {"R","Bl","Gre"};
		String[] expected_colors = {"Red","Blue","Green"};
		
		Boolean confirm = new autofillPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.enterMultipleColorsById(autofill_colors,"autoCompleteMultipleContainer")
				.confirmAutoComplete(expected_colors);
				
	}
	@Test
	public void selectDateUsingStringValue() {
		String birthday = "09/19/1997";
		Boolean date = new DatePickerPage(this.getDriver(),this.getBaseUrl())
				.navigate()
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
		
		Boolean date = new DatePickerPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.enterSelectDateUsingValues(month,day,year)
				.confirmSelectDateEntered(expected);
		
		assertTrue(date);
	}
	
	@Test
	public void sliderTest() {
		int[] values = {50,30,20,80};
		boolean slider = new SliderPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.sliderToValuesAndConfirm(values);
		
		assertTrue(slider);
				
	}
	
	//FAILED
	@Test
	public void progressBar()
	{
		String expected = "30";
		String value = new ProgressBarPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.stopAtValue("70")
				.stopAtValue(expected)
				.getValueOfProgressBar();
		
		assertEquals(value,expected,"Values should match");
	}
	
	@Test
	public void switchTab() {
		
		Boolean tab = new TabsPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.clickById("demo-tab-origin")
				.checkIfActive("demo-tab-origin");
		
		assertTrue(tab);
	}
	
	@Test
	public void toolTipTest()
	{
		Boolean toolTip = new ToolTipsPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.confirmToolTipById("toolTipButton");
		assertTrue(toolTip);	
	}
	
	
	@Test
	public void menuTest()
	{
		Boolean visible =new MenuPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.moveToAnchorByInnerText("Main Item 2")
				.moveToAnchorByInnerText("SUB SUB LIST")
				.moveToAnchorByInnerText("Sub Sub Item 2")
				.isAnchorDisplayedByInnerText("Sub Sub Item 2");
				
		assertTrue(visible);		
	}
	
	@Test
	public void selectMenuTest()
	{

		String color = "Green";
		
		boolean selected = new SelectMenuPage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.clickById("oldSelectMenu")
				.clickOptionByValue("2")
				.confirmValueSelected(color);

	}
	
	@Test
	public void switchOrderList() {
		String expected="ThreeFiveTwoSixOneFour";
		String order = new SortPageObject(this.getDriver(),this.getBaseUrl())
				.navigate()
				.dragAndDropAfter("One","Six")
				.dragAndDropAfter("Two","Five")
				.dragAndDropAfter("Four","One")
				.confirmOrder();
		
		assertEquals(order,expected,"the order should match");
	}
	
	@Test
	public void selectableGridTest() {
		String expected = "TwoThreeEight";
		String selected = new SelectablePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.clickById("demo-tab-grid")
				.clickLiByInnerText("Two")
				.clickLiByInnerText("Eight")
				.clickLiByInnerText("Three")
				.getSelectedValues();
		
		assertEquals(selected,expected,"the values should match");
	}
	
	@Test
	public void resizeTextBoxTest() {
		String expected = "width: 210px; height: 250px;";
		String size = new ResizablePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.resizebox(10,50)
				.getDimensions("resizableBoxWithRestriction");
		
		System.out.println(size);
		
		assertEquals(size,expected,"the sizes should match");
	}
	
	@Test
	public void dragAndDropTest() {
		String source = "draggable";
		String target = "droppable";
		boolean dropped = new DroppablePage(this.getDriver(),this.getBaseUrl())
				.navigate()
				.draganddrop(source,target)
				.confirmDropped();
		
		assertTrue(dropped);
	}
}
