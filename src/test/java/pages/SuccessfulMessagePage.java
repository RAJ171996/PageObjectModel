
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulMessagePage {

	private WebDriver driver;

	// Locators
	private final By successfulTextMessage = By.xpath("//div[@id='messageContain']");

	// Constructor
	public SuccessfulMessagePage(WebDriver driver) {
		this.driver = driver;
	}

	public void validateSuccessfulTextMessage() {
		String actualMessage = driver.findElement(successfulTextMessage).getText();
		String expectedMessage = "Registration Form is Successfully Submitted.";
		System.out.println("Actual Message: " + actualMessage);
		String[] parts = actualMessage.split("The Transaction ID :");
		String message = parts[0].trim();
		System.out.println("Message: " + message);
		String transactionId = parts[1].trim();
		System.out.println("Transaction ID: " + transactionId);

		// Validate the actual message contains expected message
		if (actualMessage.contains(expectedMessage)) {
			System.out.println("Validation Passed: The message contains the expected text.");
		} else {
			System.out.println("Validation Failed: The message does not contain the expected text.");
		}

	}

}
