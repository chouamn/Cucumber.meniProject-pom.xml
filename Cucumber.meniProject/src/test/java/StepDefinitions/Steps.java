package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import ch.qos.logback.core.joran.action.Action;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import junit.framework.Assert;
import pageObjects.AddCustomerPage_01;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass{

	@Before
	public void setup() throws IOException 
	{
		logger=logger.getLogger("Cucumber.meniProject"); // Added logger
		PropertyConfigurator.configure("log4j.properties");// Add logger 

		//Reading properties
		configprop=new Properties();
		FileInputStream configpropfile=new FileInputStream("config.properties");
		configprop.load(configpropfile);



		lp=new LoginPage(driver);


		String br=configprop.getProperty("browser");
		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
			driver=new ChromeDriver();	
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", configprop.getProperty("firefoxpath"));
			driver=new FirefoxDriver();	
		}	   

		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", configprop.getProperty("iepath"));
			driver=new InternetExplorerDriver();	
		}	      
		logger.info("Launching browser");
	}

	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {

		lp=new LoginPage(driver);

	}

	@When("user opens URL {string}")
	public void user_opens_URL(String url) {
		logger.info("Open URL");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("user enters Email as {string} and password as {string}")
	public void user_enters_Email_as_and_password_as(String email, String password) {
		logger.info("providing login details");
		lp.setuserName(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() {
		logger.info("started login ");
		lp.ClickLogin();
	}

	@Then("page Titile should be {string}")
	public void page_Titile_should_be(String title) {

		if (driver.getPageSource().contains("Login was unsuccessful."))

		{
			driver.close();
			logger.info("login passed");
			Assert.assertTrue(false);
		}else {
			logger.info("login failed");
			Assert.assertEquals(title , driver.getTitle());
		}
	}

	@When("User click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		logger.info("Click on logout linck ");
		lp.ClickLogout();
		Thread.sleep(3000);
	}

	//	@Then("page title should be {string}")
	//	public void page_title_should_be(String string) {

	//	}

	@Then("close browser")
	public void close_browser() {
		logger.info("closing browser");
		driver.quit();
	}
	// Customer feature stepDefinitions

	@Then("user can view Dashboard")
	public void user_can_view_Dashboard() {
		addcust=new AddCustomerPage_01(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getPageTitle());
	}

	@When("user click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException {
		Thread.sleep(3000);
		addcust.clickOnCustomersMenu();
	}

	@When("click on customers menu item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
		addcust.clickOnCustomersMenuItem();
	}

	@When("click on add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addcust.clickOnAddnew();
		//	Actions act = new Actions(driver);
		//@FindBy(xpath="//*[@href='/Admin/Customer/List' or class='nav-icon far fa-dot-circle']") @CacheLookup WebElement btnAddCustomers;
		//WebElement btnAddCustomers= driver.findElement(By.xpath("//*[@href='/Admin/Customer/List' or class='nav-icon far fa-dot-circle']"));
		//act.moveToElement(btnAddCustomers).click();
		Thread.sleep(3000);
	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getPageTitle());  
	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		logger.info("Adding new customer ");
		String email=randomstring()+"@gmail.com";	
		addcust.setEmail(email);
		addcust.setPassword("test123");

		// Registered - default 
		// The customer cannot be in both "Guests" and " Registered" customer roles
		// Add the customer to " Guests or Registered customer role
		addcust.setCustomerRoles("Guest");
		Thread.sleep(2000);
		addcust.setManagerOfVendor("Vendor 2");
		addcust.setGender("Male");
		addcust.setFirstName("chou");
		addcust.setLastName("Ghe");
		addcust.setDob("01/05/1985");
		addcust.setCompanyName("SAHARATECH");
		addcust.setAdminContent("this is for testing ......");
	}

	@When("click on Save button")
	public void click_on_Save_button() {
		logger.info("saving customer data ");
		addcust.clickOnSave();
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	}

	// steps for searching customer using Email Id 

	@When("click on customers Menu item")
	public void click_on_customers_Menu_item() throws InterruptedException 
	{
		logger.info(" searching customer using Email Id");
		Thread.sleep(3000);
		addcust.clickOnCustomersMenuItem();
	}

	@When("Enter customer Email")
	public void enter_customer_Email() throws InterruptedException 
	{

		searchCustomer=new SearchCustomerPage(driver);
		searchCustomer.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException 
	{
		searchCustomer.ClickOnSearch();
		Thread.sleep(3000);
	}

	@Then("User should found Email in search table")
	public void user_should_found_Email_in_search_table() {
		boolean status=searchCustomer.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}

	//	Searching customer by using firstname and lastname

	@When("Enter customer FirstName")
	public void enter_customer_FirstName() {
		logger.info("Searching customer by using firstname and lastname");
		searchCustomer=new SearchCustomerPage(driver);
		searchCustomer.setFirstName("Victoria");
	}

	@When("Enter customer lastName")
	public void enter_customer_lastName() {
		searchCustomer.setLastName("Terces");
	}

	@Then("User should found Name in the search table")
	public void user_should_found_Name_in_the_search_table() 
	{
		boolean  status = searchCustomer.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	}


















}
