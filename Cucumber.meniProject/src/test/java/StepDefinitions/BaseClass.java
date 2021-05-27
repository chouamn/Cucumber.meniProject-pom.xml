package StepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage_01;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver ;
	public LoginPage lp;
	public AddCustomerPage_01 addcust;
	public SearchCustomerPage searchCustomer;
	public static Logger logger;
	public Properties configprop;
	
// create for generating randome string for email 
public static String randomstring ()
{ String generatedString1 = RandomStringUtils.randomAlphabetic(5);
return( generatedString1);
}
	
	
	
	
}
	
	

