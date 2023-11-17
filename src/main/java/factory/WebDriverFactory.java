/**
 * 
 */
package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * ThreadLocal concept for parallel execution This method is used to initialize
 * the threadlocal driver on the basis of given browser
 * 
 * @param browser
 * @return this will return tlDriver
 */
public class WebDriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver initializeBrowser(String browserName) {

		System.out.println();
		if (browserName.equals("chrome")) {
			tlDriver.set(new ChromeDriver());// when ChromeDriver initialized, it will set with tlDriver. it will create
												// local driver copy for the specific thread
		} else if (browserName.equals("firefox")) {
			tlDriver.set(new FirefoxDriver());
		} else if (browserName.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser value");

		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	/**
	 * This is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
