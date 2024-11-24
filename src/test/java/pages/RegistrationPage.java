package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver;

	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Page elements (variables)

    // First Name
    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstName;

    // Last Name
    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastName;

    // Email
    @FindBy(xpath = "//input[@id='emailId']")
    WebElement email;

    // Phone
    @FindBy(xpath = "//input[@id='contactNumber']")
    WebElement phone;

    // Username
    @FindBy(xpath = "//input[@id='usr']")
    WebElement username;

    // Password
    @FindBy(xpath = "//input[@id='pwd']")
    WebElement password;



    // Submit button
    @FindBy(xpath = "//input[@value='Submit']")
    WebElement submitButton;

    // Methods to interact with elements

    // Enter First Name
    public void enterFirstName(String fName) {
        firstName.clear();
        firstName.sendKeys(fName);
    }

    // Enter Last Name
    public void enterLastName(String lName) {
        lastName.clear();
        lastName.sendKeys(lName);
    }

    // Enter Email
    public void enterEmail(String userEmail) {
        email.clear();
        email.sendKeys(userEmail);
    }

    // Enter MobileNumber
    public void enterMobileNumber(String userMobileNo) {
        phone.clear();
        phone.sendKeys(userMobileNo);
    }

    // Enter username
    public void enterUserName(String uname) {
    	username.clear();
    	username.sendKeys(uname);
    }

    // Enter Password
    public void enterPassword(String userPassword) {
        password.clear();
        password.sendKeys(userPassword);
    }
    // Click Submit button
    public void clickOnSubmitButton() {
    	submitButton.click();
    }
}
