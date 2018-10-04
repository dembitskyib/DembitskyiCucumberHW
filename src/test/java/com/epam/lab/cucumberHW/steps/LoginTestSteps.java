package com.epam.lab.cucumberHW.steps;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.epam.lab.cucumberHW.businessObjects.GmailLoginBO;
import com.epam.lab.cucumberHW.parsers.PropertyParser;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestSteps {
	private final String PROPERTIES_PATH = "src/test/resources/com/epam/lab/cucumberHW/config.properties";
	private final String INITIAL_PAGE = "https://www.google.com/gmail/";
	private WebDriver driver;
	private PropertyParser propertyParser;
	private GmailLoginBO gmailLoginBO;

	@Before
	public void configDriver() {
		propertyParser = new PropertyParser(PROPERTIES_PATH);
		System.setProperty("webdriver.chrome.driver", propertyParser.getProperty("chromeDriverPath"));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(propertyParser.getIntProperty("implicitlyWait"), TimeUnit.SECONDS);
		gmailLoginBO = new GmailLoginBO(driver, propertyParser.getIntProperty("pageUpdateTimeOut"));
	}

	@Given("^User is on Gmail login page$")
	public void goToGmail() {
		gmailLoginBO.redirectToPage(INITIAL_PAGE);
	}

	@When("^He types email as \"(.*)\"$")
	public void typeEmailAndSubmit(String email) {
		gmailLoginBO.typeEmailAndSubmit(email);
	}

	@And("^He types password as \"(.*)\"$")
	public void typePasswordAndSubmit(String password) {
		gmailLoginBO.typePasswordAndSubmit(password);
	}

	@Then("^User should be redirected to his Gmail page")
	public void checkUrl() {
		assertTrue(gmailLoginBO.isURLCorrect("inbox"));
	}

	@After
	public void quitDriver() {
		driver.quit();
	}

}
