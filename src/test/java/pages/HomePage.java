package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	public WebDriver driver;
	Actions actions;

	// Locators
	By demoSitesMenu = By.xpath("(//a[contains(text(),'Demo Sites')])[2]");
	By practiceAutomationMenu = By.xpath("(//a[contains(text(),'Practice Automation')])[2]");
	By registrationFormLink = By.xpath("(//a[normalize-space()='Registration Form'])[2]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
	}

	public void hoverOnDemoSites() {
		actions.moveToElement(driver.findElement(demoSitesMenu)).perform();
	}

	public void hoverOnPracticeAutomation() {
		actions.moveToElement(driver.findElement(practiceAutomationMenu)).perform();
	}

	public void clickOnRegistrationForm() {
		driver.findElement(registrationFormLink).click();
	}
}
