package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sun.jdi.PathSearchingVirtualMachine;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	public WebDriver ldriver;
	WaitHelper waithelper;
	
	
	public SearchCustomerPage(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(ldriver, this);
	waithelper=new WaitHelper(ldriver);
	}
	
	
	//Webelements
	@FindBy(id="SearchEmail")
	@CacheLookup
	WebElement emailSearchField;
	
	@FindBy(id="SearchFirstName")
	@CacheLookup
	WebElement fNameSearchField;
	
	@FindBy(id="SearchLastName")
	@CacheLookup
	WebElement lNameSearchField;
	
	@FindBy(name="SearchCompany")
	@CacheLookup
	WebElement companySearchField;
	
	@FindBy(name="SearchMonthOfBirth")
	@CacheLookup
	WebElement monthSearchField;
	
	@FindBy(name="SearchDayOfBirth")
	@CacheLookup
	WebElement daySearchField;
	
	@FindBy(css="button#search-customers")
	@CacheLookup
	WebElement searchBtn;
	
	@FindBy(xpath="//table[@id='customers-grid']")
	@CacheLookup
	WebElement customerTable;
	
	@FindBy(xpath="//table[@id='customers-grid']/tbody/tr")
	@CacheLookup
	List<WebElement> customerTableRows;
	
	
	@FindBy(xpath="//table[@id='customers-grid']/tbody/tr/td")
	@CacheLookup
	List<WebElement> customerTableColumns;
	
	
	//action methods
	public void setByEmailId(String emailId) {
	//	waithelper.waitForElement(emailSearchField,30);
		emailSearchField.clear();
		emailSearchField.sendKeys(emailId);
	}
	
	public void setFirstName(String firstName) {
		fNameSearchField.sendKeys(firstName);
	}
	
	public void setLastName(String LastName) {
		lNameSearchField.sendKeys(LastName);
	}
	
	public void setCompanyName(String company) {
		companySearchField.sendKeys(company);
	}
	
	public void setDateOfBirth(int month,int day) {
//		monthSearchField.
		Select monthSelect=new Select(monthSearchField);
		monthSelect.selectByIndex(month);
		
		Select daySelect=new Select(daySearchField);
		daySelect.selectByIndex(day);
		
	}
	
	public void clickOnSearchBtn() throws InterruptedException {
		searchBtn.click();
		Thread.sleep(5000);
	}
	
	public int getNoOfRows() {
		return customerTableRows.size();
	}

	public int getNoOfColumns() {
		return customerTableColumns.size();
	}
	
	public boolean searchByEmailID(String email) {
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++) {
			String emailId=customerTable.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			if(emailId.equals(email)) {
				flag=true;
			}
			
		}
		return flag;
	}
	
	public boolean searchByName(String name) {
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++) {
			String actualName=customerTable.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			if(actualName.equals(name)) {
				flag=true;
			}
			
		}
		return flag;
	}
}
