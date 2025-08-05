package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	private Actions actions;
	private WebDriverWait wait;

	private By demoSitesMenu = By.xpath("(//a[contains(text(),'Demo Sites')])[2]");
	private By practiceAutomationMenu = By.xpath("(//a[contains(text(),'Practice Automation')])[2]");
	private By registrationFormLink = By.xpath("(//a[normalize-space()='Registration Form'])[2]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public void hoverOnDemoSites() {
		WebElement demo = wait.until(ExpectedConditions.visibilityOfElementLocated(demoSitesMenu));
		actions.moveToElement(demo).perform();
	}

	public void hoverOnPracticeAutomation() {
		WebElement practice = wait.until(ExpectedConditions.visibilityOfElementLocated(practiceAutomationMenu));
		actions.moveToElement(practice).perform();
	}

	public void clickOnRegistrationForm() {
		WebElement registrationForm = wait.until(ExpectedConditions.elementToBeClickable(registrationFormLink));
		actions.moveToElement(registrationForm).click().perform();
	}

	public void navigateToRegistrationForm() {
		hoverOnDemoSites();
		hoverOnPracticeAutomation();
		clickOnRegistrationForm();
	}
}
