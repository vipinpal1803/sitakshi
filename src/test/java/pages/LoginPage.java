package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='usr']")
	WebElement usernameTextField;

	@FindBy(xpath="//input[@id='pwd']")
	WebElement passwordTextField;

	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;

	@FindBy(xpath="//button[@id='NewRegistration']")
	WebElement  NewUserRegistrationLink;

	public void enterUserName()
	{
		usernameTextField.sendKeys("sa");
	}

	public  void enterPassword()
	{
		passwordTextField.sendKeys("sa");
	}
	
	
	public void  user_enter_credentail_username_as_and_password_as(String username, String password)
	{
		
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
	}
	
	public void newUserRegistrationButton()
	{
		
		NewUserRegistrationLink.click();
		
	}
	
	public  void clickOnLoginButton()
	{
		loginBtn.click();
	}

}
