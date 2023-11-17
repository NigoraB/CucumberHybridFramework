/**
 * 
 */
package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.WebDriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class AccountPageSteps {
	private static String title;
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;

	@Given("User has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		List<Map<String, String>> credentialsList = credTable.asMaps();
		String username = credentialsList.get(0).get("username");
		String password = credentialsList.get(0).get("password");
		HomePage homePage = new HomePage(WebDriverFactory.getDriver());
		loginPage = homePage.navigateToLoginPage();
		accountPage = loginPage.doLogin(username, password);
	}

	@Given("user is on My Account page")
	public void user_is_on_my_account_page() {

		accountPage.getHeaderText();

	}

	@When("user gets the title of the page")
	public String user_gets_the_title_of_the_page() {

		title = accountPage.getAccountPageTitle();
		return title;
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {

		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("user gets My account section")
	public void user_gets_my_account_section(DataTable sectionsTable) {

		List<String> expAccountSectionsList = sectionsTable.asList();
		System.out.println("Expected account sections list: " + expAccountSectionsList);

		List<String> actualAccountSectionList = accountPage.getAccountSectionsList();
		System.out.println("Actual size: "+actualAccountSectionList.size());
		System.out.println("Actual account sections list: " + actualAccountSectionList);

		Assert.assertEquals(expAccountSectionsList, actualAccountSectionList);
	}

	@Then("count should be {int}")
	public void count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountPage.getAccountSectionCount() == expectedSectionCount);

	}

}
