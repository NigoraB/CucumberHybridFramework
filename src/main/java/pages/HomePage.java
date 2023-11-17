package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
				this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);	
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	@FindBy(xpath="//i[@class='fa fa-phone']//..")
	WebElement contactUsLink;
	
	public void clickOnMyAccount() {
		
		elementUtils.clickOnElement(myAccountDropMenu,Constants.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public LoginPage selectLoginOption() {
		
		elementUtils.clickOnElement(loginOption,Constants.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
		
	}
	
	public LoginPage navigateToLoginPage() {
		elementUtils.clickOnElement(myAccountDropMenu,Constants.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.clickOnElement(loginOption,Constants.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	
	public RegisterPage navigateToRegisterAccountPage() {
		elementUtils.clickOnElement(myAccountDropMenu,Constants.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.clickOnElement(registerOption,Constants.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);	
	}
	
	public ContactUsPage navigateToContactUsPage() {
		elementUtils.clickOnElement(contactUsLink, Constants.EXPLICIT_WAIT_BASIC_TIME);
		return new ContactUsPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		
		elementUtils.clickOnElement(registerOption,Constants.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
		
	}
	
	public void enterProductIntoSearchBox(String productText) {
		
		elementUtils.typeTextIntoElement(searchBoxField,productText,Constants.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public SearchResultsPage clickOnSearchButton() {
		
		elementUtils.clickOnElement(searchButton,Constants.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultsPage(driver);
		
	}
	

}
