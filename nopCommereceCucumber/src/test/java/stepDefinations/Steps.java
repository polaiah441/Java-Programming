package stepDefinations;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass{
	
	String emailId;

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		logger=Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("log4j.properties");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver");
		driver=new ChromeDriver();
		
		logger.info("*****************Launching URL*****************");
		lp=new LoginPage(driver);
	
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		logger.info("*****************Opening browser*****************");
		driver.get(url);
	
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String uname, String passwd) {
		lp.setUsername(uname);
		lp.setPassword(passwd);
	
	}

	@When("click on login")
	public void click_on_login() {
		logger.info("*****************Login started*****************");
		lp.clickOnLogin();
	
	}

	
	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title, driver.getTitle());
		}
	
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() {
	   lp.clickOnLogout();
	}

	@Then("close browser")
	public void close_browser() {
	    driver.quit();
	}
	
	@Then("close browser1")
	public void close_browser1() {
	    driver.quit();
	}
	
	//Customers feature definations
	
	@Then("user can view Dashboard")
	public void user_can_view_dashboard() {
	addCust=new AddCustomerPage(driver);
	Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}



	
	@When("user clicks on Customers Menu")
	public void user_clicks_on_customers_menu() {
		addCust.clickonCustomerstab();
	
	}
	@When("click on Customer Menu Item")
	public void click_on_customer_menu_item() {
		addCust.clikcOnCustomerMenu();
	
	}
	@When("click on Add new button")
	public void click_on_add_new_button() {
		addCust.ClickAddNewCustomerBtn();
	}
	@Then("user can view Add New customer page")
	public void user_can_view_add_new_customer_page() {
	
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	
	}
	@When("user enters customer info")
	public void user_enters_customer_info() {
		emailId=randomString()+"@gmail.com";
		addCust.setCustomerEmailID(emailId);
		addCust.setCustomerPassword("test123");
		addCust.setCustFirstname("pola");
		addCust.setCustLastName("hello");
		addCust.setGender("Male");
		addCust.setCustDOB("11/11/2009");
		addCust.setCustCompany("hello123");
		addCust.setCustTaxExempt("yes");
		//addCust.custNewsLetter("me");
		addCust.addAdminComments("hi hello nop admin role");
	
	
	}
	@When("click on save button")
	public void click_on_save_button() {
		addCust.clickonCustSaveBtn();
	
	}
	@Then("user can view confirmation page {string}")
	public void user_can_view_confirmation_page(String string) {
	
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	}
	

	//Customer search by mail id
	@When("enter customer email id")
	public void enter_customer_email_id() {
	
		searchCustomer=new SearchCustomerPage(driver);
		searchCustomer.setByEmailId("mXVcJ@gmail.com");
	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCustomer.clickOnSearchBtn();
	}
	@Then("User should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
		boolean status=searchCustomer.searchByEmailID("mXVcJ@gmail.com");
		Assert.assertEquals(true, status);
	}

	
////Customer search by name
	@When("enter customer first name")
	public void enter_customer_first_name() {
		searchCustomer=new SearchCustomerPage(driver);
		searchCustomer.setFirstName("pola");
	}


	@When("enter customer last name")
	public void enter_customer_last_name() {
		searchCustomer.setLastName("hello");
	}
	
	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() {
		boolean status=searchCustomer.searchByName("pola hello");
		Assert.assertEquals(true, status);
	
	}
	
	@When("User enters username and password")
	public void user_enters_username_and_password(DataTable table) {
	   
	   List<List<String>> data = table.asLists(String.class);
		lp.setUsername(data.get(0).get(0));
		lp.setPassword(data.get(0).get(1));
	    
	}
	
	@When("User enters credentials")
	public void user_enters_credentials(DataTable mapsTable) {

	//	Map<String, String> data=(Map<String, String>) mapsTable.asMaps(String.class,String.class);
		for(Map<Object, Object> data : mapsTable.asMaps(String.class,String.class)) {
			lp.setUsername((String) data.get("username"));
			lp.setPassword((String) data.get("password"));
			
		}
	}
}
