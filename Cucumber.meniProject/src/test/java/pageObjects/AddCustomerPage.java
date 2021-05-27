package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver) 
	{
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//*[@xpath='1']") @CacheLookup WebElement lnkCustomers_menu;
	@FindBy(xpath="//*[@href='/Admin/Customer/List' or class='nav-icon far fa-dot-circle']") @CacheLookup WebElement lnkCustomers_menuitem;
	@FindBy(xpath="//p[contains(text(),'Customer roles')]") @CacheLookup WebElement lnkCustomer_roles;
	//@FindBy(xpath="//td[contains(text(),'Administrators')]") @CacheLookup WebElement Administrators_roles;
	//@FindBy(xpath=" //td[contains(text(),'Forum Moderators')]") @CacheLookup WebElement Forum_Moderators_roles;
	//@FindBy(xpath=" //td[contains(text(),'Guests')]") @CacheLookup WebElement Guests_roles;
	//@FindBy(xpath=" //td[contains(text(),'Registered')]')]") @CacheLookup WebElement Registered_roles;
	//@FindBy(xpath=" //td[contains(text(),'Vendors')]]") @CacheLookup WebElement Vendors_roles;
	
	@FindBy(xpath="//*[@href='/Admin/Customer/List' or class='nav-icon far fa-dot-circle']") @CacheLookup WebElement btnAddCustomers;
	@FindBy(id="Email")@CacheLookup WebElement TxtEmail;
	@FindBy(id="Password")@CacheLookup WebElement TxtPassword;
	@FindBy(id="FirstName")@CacheLookup WebElement TxtFirstName;
	@FindBy(id="LastName")@CacheLookup WebElement TxtLastName;
	@FindBy(id="Gender_Male")@CacheLookup WebElement Gender_Male;
	@FindBy(id="Gender_Female")@CacheLookup WebElement Gender_Female;
	@FindBy(id="DateOfBirth")@CacheLookup WebElement DateOfBirth;
	@FindBy(id="Company")@CacheLookup WebElement Company_name;
	@FindBy(id="IsTaxExempt")@CacheLookup WebElement CheckBoxOfIstaxexempt;
	@FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div") @CacheLookup WebElement btnNewsletter;
	@FindBy(xpath="//li[contains(text(),'Your store name')]") @CacheLookup WebElement btnYourStorename;
	@FindBy(xpath="//li[@id='a203fe3f-1bf4-4933-80d5-af819c7abb13']") @CacheLookup WebElement btnTestStore2;
	@FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div/input") @CacheLookup WebElement btnCustomerRoles;
	@FindBy(xpath="//li[contains(text(),'Administrators')]']") @CacheLookup WebElement Administrators_roles;
	@FindBy(xpath="//li[contains(text(),'Forum Moderators')]") @CacheLookup WebElement Forum_Moderators_roles;
	@FindBy(xpath="//li[contains(text(),'Guests')]") @CacheLookup WebElement Guests_roles;
	@FindBy(xpath="//li[contains(text(),'Registered')]") @CacheLookup WebElement Registered_roles;
	@FindBy(xpath=" //li[contains(text(),'Vendors')]") @CacheLookup WebElement  Vendors_roles;
	@FindBy(xpath="//select[@id='VendorId']") @CacheLookup WebElement  drpmgofvender;
	@FindBy(xpath="//textarea[@id='AdminComment']") @CacheLookup WebElement  txtAdmincomment;
	@FindBy(xpath="////button[@name='save']")@CacheLookup WebElement btnSvae;

	// Actions Methods 
	
	public void ClickOnCustomersMenu() 
	{
		lnkCustomers_menu.click();
	};
	
	public void ClickOnCustomersMenuItem() 
	{
		lnkCustomers_menuitem.click();
	};
	
	public void ClickOnAddCustomers() 
	{
		btnAddCustomers.click();
	};
	
	public void setEmail(String email) 
	{
		TxtEmail.sendKeys(email);
	};
	
	public void setPassword(String pwd) 
	{
		TxtPassword.sendKeys(pwd);
	};
	
	public void setFirstName(String uname) 
	{
		TxtFirstName.sendKeys(uname);
	};	
	
	public void setLastName(String lname) 
	{
		TxtLastName.sendKeys(lname);
	};	
	
	public void setGenderM() 
	{
		Gender_Male.click();
	};	
	
	public void setGenderF() 
	{
		Gender_Female.click();
	};	
	
	public void DateOfBirth(String DOB) 
	{
		DateOfBirth.sendKeys();
	};	
	
	public void SetCompany_name(String Cname) 
	{
		Company_name.sendKeys();
	};	
	
	public void SetbtnNewsletterS() 
	{
		btnNewsletter.click();
	};	
	
	public void SetbtnYourStorename() 
	{
		btnYourStorename.click();
	};	
	
	public void SetbtnTestStore2() 
	{
		btnTestStore2.click();
	};	
	
	public void setCustomerRoles() 
	{
	 btnCustomerRoles.click();
	}
	
	
	
	
	
	
	
}
