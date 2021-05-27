package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver Ldriver;
	public LoginPage(WebDriver rdriver) 
	{
		Ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	};
@FindBy(id="Email") @CacheLookup WebElement TxtEmail;
@FindBy(xpath="//input[@id='Password']") @CacheLookup WebElement Txtpassword;
@FindBy(xpath="//*[@type='submit']") @CacheLookup WebElement buttonLogin;
@FindBy(linkText="Logout") @CacheLookup WebElement buttonLogout;

public void setuserName (String Uname) 
{
	TxtEmail.clear();
	TxtEmail.sendKeys(Uname);
};
public void setPassword(String pass)
{
	Txtpassword.clear();
	Txtpassword.sendKeys(pass);
};

public void ClickLogin() 
{
	buttonLogin.click();	
};

public void ClickLogout() 
{
	buttonLogout.click();	
};

  
}
