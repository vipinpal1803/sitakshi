package pages;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//input[@type='checkbox']")
	WebElement humbugerMenu;

	@FindBy(xpath="//li[normalize-space()='Sign In Portal']")
	WebElement signInButton;

	public void clickOnHumbugerMenu()
	{
		humbugerMenu.click();
	}

	public void clickOnsignInButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(signInButton));
	    
	    try {
	        signInButton.click();
	    } catch (ElementNotInteractableException e) {
	        // Fallback to JS click if normal click fails
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", signInButton);
	    }
	}




}
