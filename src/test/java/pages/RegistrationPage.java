package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	public WebDriver driver;

	// Locators
	By firstNameTextBox = By.xpath("//input[@id='vfb-5']");
	By lastNameTextBox = By.xpath("//input[@id='vfb-7']");
	By maleRadioBtn = By.xpath("//input[@id='vfb-31-1']");
	By seleniumWebDriverCheckBox = By.xpath("//input[@id='vfb-20-0']");
	By devOpsCheckBox = By.xpath("//input[@id='vfb-20-3']");
	By streetAddressTextBox = By.xpath("//input[@id='vfb-13-address']");
	By aptSuiteTextBox = By.xpath("//input[@id='vfb-13-address-2']");
	By cityTextBox = By.xpath("//input[@id='vfb-13-city']");
	By stateTextBox = By.xpath("//input[@id='vfb-13-state']");
	By postalCodeTextBox = By.xpath("//input[@id='vfb-13-zip']");
	By selectCountryDropdown = By.xpath("//select[@id='vfb-13-country']");
	By emailTextBox = By.xpath("//input[@id='vfb-14']");
	By dateOfDemo = By.xpath("//input[@id='vfb-18']");
	By convinientTimeHH = By.xpath("//select[@id='vfb-16-hour']");
	By convinientTimeMM = By.xpath("//select[@id='vfb-16-min']");
	By enterYourQuery = By.xpath("//textarea[@id='vfb-23']");
	By phoneNumberTextBox = By.xpath("//input[@id='vfb-19']");
	By verificationTextBox = By.xpath("//input[@id='vfb-3']");
	By getVerificationNumber = By.xpath("//label[normalize-space()='Example: 33']");
	By submitButton = By.xpath("//input[@id='vfb-4']");

	// Constructor
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterFirstName(String firstName) {
		driver.findElement(firstNameTextBox).clear();
		driver.findElement(firstNameTextBox).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(lastNameTextBox).clear();
		driver.findElement(lastNameTextBox).sendKeys(lastName);
	}

	public void clickMaleRadioBtn() {
		driver.findElement(maleRadioBtn).click();
	}

	public void checkSeleniumWebDriverCheckBox() {
		driver.findElement(seleniumWebDriverCheckBox).click();
	}

	public void unCheckDevOpsCheckBox() {
		driver.findElement(devOpsCheckBox).click();
	}

	public void enterStreetAddress(String streetAddress) {

		driver.findElement(streetAddressTextBox).clear();
		driver.findElement(streetAddressTextBox).sendKeys(streetAddress);
	}

	public void enterAptSuite(String aptSuite) {
		driver.findElement(aptSuiteTextBox).clear();
		driver.findElement(aptSuiteTextBox).sendKeys(aptSuite);
	}

	public void enterCity(String city) {

		driver.findElement(cityTextBox).clear();
		driver.findElement(cityTextBox).sendKeys(city);
	}

	public void enterState(String state) {

		driver.findElement(stateTextBox).clear();
		driver.findElement(stateTextBox).sendKeys(state);
	}

	public void enterPostalCode(String postalCode) {

		driver.findElement(postalCodeTextBox).clear();
		driver.findElement(postalCodeTextBox).sendKeys(postalCode);
	}

	public void selectCountry(String country) {

		Select countryDropdown = new Select(driver.findElement(selectCountryDropdown));
		countryDropdown.selectByVisibleText(country);
	}

	public void enterEmail(String email) {

		driver.findElement(emailTextBox).clear();
		driver.findElement(emailTextBox).sendKeys(email);
	}

	public void enterDateOfDemo(String date) {

		driver.findElement(dateOfDemo).clear();
		driver.findElement(dateOfDemo).sendKeys(date);
	}

	public void selectConvenientTimeHH(String hour) {
		Select hhDropdown = new Select(driver.findElement(convinientTimeHH));
		hhDropdown.selectByVisibleText(hour);
	}

	public void selectConvenientTimeMM(String minute) {
		Select mmDropdown = new Select(driver.findElement(convinientTimeMM));
		mmDropdown.selectByVisibleText(minute);
	}

	public void enterPhoneNumber(String phoneNumber) {

		driver.findElement(phoneNumberTextBox).clear();
		driver.findElement(phoneNumberTextBox).sendKeys(phoneNumber);
	}

	public void enterYourQuery(String query) {
		driver.findElement(enterYourQuery).clear();
		driver.findElement(enterYourQuery).sendKeys(query);
	}

	public void enterVerificationNumber() {

		// Get the verification number text from the label
		String verificationText = driver.findElement(getVerificationNumber).getText();
		System.out.println("Verification Text: " + verificationText);
		// Extract the number from the text
		String extractedNumber = verificationText.split(": ")[1].trim();
		System.out.println("Extracted Verification Number: " + extractedNumber);
		// clear the verification text box and enter the extracted number
		driver.findElement(verificationTextBox).clear();
		driver.findElement(verificationTextBox).sendKeys(extractedNumber);
	}

	public void clickSubmitButton() {
		// Scroll to the submit button and click it
		WebElement submitBtn = driver.findElement(submitButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
	}

}
