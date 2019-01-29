package serenitbdd.steps;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.Step;
import serenitybdd.pages.AirbnbHomePage;
import serenitybdd.pages.AirbnbSignupPage;

public class AirbnbSignUpSteps {
	AirbnbHomePage homepage;
	AirbnbSignupPage signup;

	@Step("user opens the Airbnb homepage")
	public void openTheAirbnbWebPortal(WebDriver driver) {
		homepage = new AirbnbHomePage(driver);
		signup = new AirbnbSignupPage(driver);
	}

	@Step("user is redirected to sign up page")
	public void redirectUserToTheSignUpPAge() {
		homepage.gotoSignUp();
	}

	@Step("user should fill the details required to signup")
	public void userFillsTheDetailsforSubmission() {
		signup.fillDetails();
		signup.submitDetails();
	}

	@Step("user must accept terms and condition to get itself registered")
	public void userShouldBeRegisteredToThePortal() {
		signup.acceptAggreement();
		signup.skipSteps();
		homepage.welcomePage();
	}

}
