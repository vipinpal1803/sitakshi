package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class StepDef {

	public WebDriver driver;
	public HomePage homePg;
	public LoginPage loginPg;
	public RegistrationPage registrationPg;

	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		homePg = new HomePage(driver);
		loginPg = new LoginPage(driver);
		registrationPg = new RegistrationPage(driver);
	}

	@When("User open URL {string}")
	public void user_open_url(String url) {
		driver.get(url);
	}

	@When("User click on humburger menu")
	public void user_click_on_humburger_menu() {
		homePg.clickOnHumbugerMenu();

	}

	@When("User click on signin portal link")
	public void user_click_on_signin_portal_link() {
		homePg.clickOnsignInButton();

	}

	@When("User enter the username")
	public void user_enter_the_username() {
		loginPg.enterUserName();

	}

	@When("User enter the password")
	public void user_enter_the_password() {
		loginPg.enterPassword();

	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		loginPg.clickOnLoginButton();
	}

	@Then("User able to see the products")
	public void user_able_to_see_the_products() {
		SoftAssert softAssert = new SoftAssert();

		String expectedformalShoeText ="Formal Shoes";
		String actualformalShoeText = driver.findElement(By.xpath("//div[@id='SmokeTests']//h3[@id='ShoeType']")).getText();
		//Assert.assertEquals(actualformalShoeText, expectedformalShoeText, "Text is mismatched");
		softAssert.assertEquals(actualformalShoeText, expectedformalShoeText, "Text is mismatched");
		softAssert.assertAll();

	}


	@When("User enter credentail username as {string} and password as {string}")
	public void user_enter_credentail_username_as_and_password_as(String username, String password) {
		loginPg.user_enter_credentail_username_as_and_password_as(username, password);
	}


	//New User Registration 

	@When("User click on NewUserRegistrationLink")
	public void user_click_on_new_user_registration_link() {
		loginPg.newUserRegistrationButton();

	}
	@When("User enter the details as follows:")
	public void user_enter_the_details_as_follow(io.cucumber.datatable.DataTable dataTable) {

		// Convert DataTable to a Map to retrieve field values easily
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		// Assuming first (and only) row in the DataTable
		String firstName = data.get(0).get("firstName");
		String lastName = data.get(0).get("lastName");
		String email = data.get(0).get("email");
		String mobile = data.get(0).get("Mobile");
		String userName = data.get(0).get("userName");
		String password = data.get(0).get("password");

		// Assuming you have a Page Object class for Registration with these methods
		registrationPg.enterFirstName(firstName);
		registrationPg.enterLastName(lastName);
		registrationPg.enterEmail(email);
		registrationPg.enterMobileNumber(mobile);
		registrationPg.enterUserName(userName);
		registrationPg.enterPassword(password);

	}
	@When("User click on submit button")
	public void user_click_on_submit_button() {
		registrationPg.clickOnSubmitButton();

	}
	@Then("User see successful message on the page")
	public void user_see_successful_message_on_the_page() {
		String expectedRegisterUsertext ="User Registered Successfully !!!";
		String actualRegisterUsertext = driver.findElement(By.xpath("//h1[normalize-space()='User Registered Successfully !!!']")).getText();
		Assert.assertEquals(actualRegisterUsertext, expectedRegisterUsertext, "User is not register successfully");

	}

	@Then("User close browser")
	public void user_close_browser() {
		driver.quit();
	}


}
