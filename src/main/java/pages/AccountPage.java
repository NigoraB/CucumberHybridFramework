package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Constants;
import utils.ElementUtils;

public class AccountPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	private WebElement MyAccountHeader;

	@FindBy(xpath = "//div[@id='content']//h2")
	private List<WebElement> MyAccountSection;

	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccountInformationOption;

	@FindBy(linkText = "Change your password")
	private WebElement changeYourPasswordOption;

	@FindBy(linkText = "Modify your address book entries")
	private WebElement ModifyYourAddressBookOption;

	@FindBy(linkText = "Modify your wish list")
	private WebElement ModifyYourWishListOption;
	
	
	//Actions
	
	public String getHeaderText() {
		return elementUtils.getTextFromElement(MyAccountHeader, 5);
	}

	public int getAccountSectionCount() {
		return MyAccountSection.size();
	}

	public List<String> getAccountSectionsList() {
		List<String> accountList = new ArrayList<>();
		for (WebElement e : MyAccountSection) {
			String text = e.getText();
			System.out.println(text);
			accountList.add(text);
		}
		return accountList;
	}

	public boolean displayStatusOfEditYourAccountInformationOption() {
		return elementUtils.displayStatusOfElement(editYourAccountInformationOption,
				Constants.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
}
