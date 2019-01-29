package serenitbdd.steps;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.Step;
import serenitybdd.pages.AirbnbHomePage;

public class AirbnbLoginSteps {

	AirbnbHomePage login;

	@Step("user opens the Airbnb portal")
	public void openTheAirbnbWebPortal(WebDriver driver) {
		login = new AirbnbHomePage(driver);
	}

	@Step("user enters the credentials")
	public void entersTheLoginCredentials(String username, String password) {
		login.enterTheCredentials(username, password);
		login.submitCredentials();
	}

	@Step("user sees the Airbnb homepage")
	public void homepageAppears() {
		login.welcomePage();

	}
	@Step("user logs out from its profile")
	public void userLogsOut() {
		login.logout();
		login.welcomePage();
		
	}
}
