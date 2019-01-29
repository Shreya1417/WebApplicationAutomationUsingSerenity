package serenitybdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import serenitybdd.base.BasePage;

//Note: defaultUrl will not work as the base URL will override the default URL value
public class AirbnbHomePage extends PageObject {

	WebDriver driver;
	WebDriverWait wait;
	EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	BasePage page;

	public AirbnbHomePage(WebDriver driver) {
		this.driver = driver;
		String baseUrl = variables.getProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL);
		driver.get(baseUrl);
		setDriver(driver);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10000);
		page = new BasePage(driver);

	}

	public void gotoSignUp() {
		page.waitVisibility(By.xpath("//div[text()='Sign up']"));
		$("//div[text()='Sign up']").click();
		page.waitVisibility(By.cssSelector("._wpwi48"));
		$("._taglxzq").click();
	}

	public void welcomePage() {
		waitForRenderedElementsToBePresent(By.xpath("//main[@id='site-content']"));
	}

	public void enterTheCredentials(String username, String password) {
		page.waitVisibility(By.xpath("//div[text()='Log in']"));
		$("//div[text()='Log in']").click();
		waitForRenderedElementsToBePresent(By.cssSelector("#email-login-email"));
		$("#email-login-email").sendKeys(username);
		waitForRenderedElements(By.cssSelector("#email-login-password"));
		$("#email-login-password").sendKeys(password);
	}

	public void submitCredentials() {
		waitForRenderedElementsToBePresent(By.cssSelector("._taglxzq"));
		$("._taglxzq").click();

	}

	public void logout() {
		welcomePage();
		page.waitVisibility(By.cssSelector("._1pa4v1p"));
		$("._1pa4v1p").click();
		waitForRenderedElementsToBePresent(By.xpath("//div[text()='Log Out']"));
		$("//div[text()='Log Out']").click();
	}
}
