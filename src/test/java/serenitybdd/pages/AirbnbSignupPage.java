package serenitybdd.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;
import serenitybdd.base.BasePage;

public class AirbnbSignupPage extends PageObject {

	WebDriver driver;
	WebDriverWait wait;
	BasePage page;

	public AirbnbSignupPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 1000);
		page = new BasePage(driver);
		setDriver(driver, 1000);
	}

	public void fillDetails() {
		page.waitVisibility(By.cssSelector("._wpwi48"));
		String emailAddress = "mersam_" + Math.round(Math.random() * (999 - 100) + 100) + "@gmail.com";
		$("#email-signup-email").sendKeys(emailAddress);
		$("//input[@id='email-signup-user[first_name]']").sendKeys("Samaira");
		$("//input[@name='user[last_name]']").sendKeys("Merchant");
		$("#email-signup-password").sendKeys("Shreya1!");
		$("//select[@id='email-signupuser[birthday_month]']").click();
		$("//select[@id='email-signupuser[birthday_month]']/option[10]").click();
		$("//select[@id='email-signupuser[birthday_day]']").click();
		$("//select[@id='email-signupuser[birthday_day]']/option[7]").click();
		$("//select[@id='email-signupuser[birthday_year]']").click();
		page.scrollToElement(By.xpath("//select[@id='email-signupuser[birthday_year]']/option[27]"));
		$("//select[@id='email-signupuser[birthday_year]']/option[27]").click();
		page.scrollToElement(By.cssSelector("._zkrkb6"));
		$("._zkrkb6").click();

	}

	public void submitDetails() {
		page.waitVisibility(By.cssSelector("._taglxzq"));
		$("._taglxzq").click();
	}

	public void acceptAggreement() {
		page.waitVisibility(By.xpath("//div[text()='Before you join']"));
		assertEquals($("//div[text()='Before you join']").getText(), "Before you join");
		$("//span[text()='Accept']").click();
		page.waitVisibility(By.xpath("//div[@class='activation-image-panel activation-image-panel--welcome']"));
		$("//button[text()='Next - 4 steps left']").click();
	}

	public void skipSteps() {
		waitForRenderedElementsToBePresent(By.cssSelector(".activation-step-panel__wrapper"));
		page.click(By.xpath("//button[text()='I’ll do this later']"));
		waitForRenderedElementsToBePresent(By.cssSelector(".activation-step-panel__wrapper"));
		page.click(By.xpath("//button[text()='I’ll do this later']"));
		waitForRenderedElementsToBePresent(By.cssSelector(".activation-step-panel__wrapper"));
		page.click(By.xpath("//button[text()='I’ll do this later']"));
		waitForRenderedElementsToBePresent(By.cssSelector(".activation-step-panel__wrapper"));
		page.click(By.xpath("//button[text()='I’ll do this later']"));
		waitForRenderedElements(By.xpath("//div[@class='activation-image-panel activation-image-panel--success']"));
		page.click(By.xpath("//button[text()='Start Exploring']"));

	}

}
