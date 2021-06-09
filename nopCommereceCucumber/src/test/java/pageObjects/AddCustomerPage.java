package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddCustomerPage {
	
	public WebDriver ldriver;
	
	
	public AddCustomerPage(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(ldriver, this);
	}
	
	
	//webelements
	
	@FindBy(xpath="//a[@href='#']/span[text()='Customers']")
	@CacheLookup
	WebElement customersTab;
	
	
	@FindBy(xpath="//span[@class='menu-item-title'][text()='Customers']")
	@CacheLookup
	WebElement customersMenu;
	
	
	@FindBy(css=".btn.bg-blue")
	@CacheLookup
	WebElement AddNewcustomerBtn;
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement custEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement custPassword;
	
	@FindBy(id="FirstName")
	@CacheLookup
	WebElement custFirstName;
	
	
	@FindBy(id="LastName")
	@CacheLookup
	WebElement custLastName;
	
	@FindBy(id="Gender_Male")
	@CacheLookup
	WebElement custGenderMale;
	
	@FindBy(id="Gender_Female")
	@CacheLookup
	WebElement custGenderFemale;

	@FindBy(id= "DateOfBirth")
	@CacheLookup
	WebElement custDOB;
	
	
	@FindBy(id= "Company")
	@CacheLookup
	WebElement custCompany;
	
	@FindBy(id= "IsTaxExempt")
	@CacheLookup
	WebElement custTaxExempt;
	
	@FindBy(id= "SelectedNewsletterSubscriptionStoreIds")
	@CacheLookup
	WebElement custNewsletterSubscription;
	
	@FindBy(id= "VendorId")
	@CacheLookup
	WebElement custVendorId;
	
	
	@FindBy(id= "AdminComment")
	@CacheLookup
	WebElement custAdminComment;
	
	@FindBy(id= "Active")
	@CacheLookup
	WebElement custActive;
	
	@FindBy(css="button[name='save']")
	@CacheLookup
	WebElement saveCustomer;
	
	
	
	//Action methods
	public String getPageTitle() {
		
		return ldriver.getTitle();
	}
	
	public void clickonCustomerstab() {
		customersTab.click();
	}
	
	public void clikcOnCustomerMenu() {
		customersMenu.click();
		
	}
	
	public void ClickAddNewCustomerBtn() {
		AddNewcustomerBtn.click();
	}
	
	public void setCustomerEmailID(String email) {
		custEmail.sendKeys(email);
	}
	
	public void setCustomerPassword(String password) {
		custPassword.sendKeys(password);
	}
	
	public void setCustFirstname(String firstName) {
		custFirstName.sendKeys(firstName);
	}
	
	public void setCustLastName(String lastName) {
		custLastName.sendKeys(lastName);
	}
	
	public void setGender(String gender) {
		if(gender=="Male"){
				custGenderMale.click();
		}else if(gender=="Female") {
			custGenderFemale.click();
		}
	}
	
	public void setCustDOB(String DOB) {
		custDOB.sendKeys(DOB);
	}
	
	public void setCustCompany(String company) {
		custCompany.sendKeys(company);
	}
	
	public void setCustTaxExempt(String taxOption) {
		if(taxOption=="yes") {
			custTaxExempt.click();
		}else{
			custTaxExempt.click();
			custTaxExempt.clear();
		}
		
	}
	
	public void custNewsLetter(String newsletter) {
		custNewsletterSubscription.sendKeys(newsletter);
		
	}
	
	public void addAdminComments(String adminComments) {
		custAdminComment.sendKeys(adminComments);
	}
	
	public void clickonCustSaveBtn() {
		saveCustomer.click();
	}

}
