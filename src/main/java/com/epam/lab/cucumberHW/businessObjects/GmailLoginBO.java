package com.epam.lab.cucumberHW.businessObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.lab.cucumberHW.pageObjectModels.GmailLoginPage;

public class GmailLoginBO {
	private final String VALUE_ATTACHED_MESSAGE = "%s: Attaching value '%s' to the '%s' field";
	private final String INITIAL_PAGE = "https://www.google.com/gmail/";
	private GmailLoginPage gmailLoginPage;
	private String threadName;
	private static final Logger logger = LogManager.getLogger(GmailLoginBO.class);

	public GmailLoginBO(WebDriver driver, int pageUpdateTimeOut) {
		gmailLoginPage = new GmailLoginPage(driver, pageUpdateTimeOut);
		threadName = Thread.currentThread().getName();
	}

	public void logIn(String email, String password) {
		gmailLoginPage.redirectToPage(INITIAL_PAGE);
		logger.info(String.format(VALUE_ATTACHED_MESSAGE, threadName, email, "email"));
		gmailLoginPage.typeEmailAndSubmit(email);
		logger.info(String.format(VALUE_ATTACHED_MESSAGE, threadName, password, "password"));
		gmailLoginPage.typePasswordAndSubmit(password);
	}

	public void typeEmailAndSubmit(String login) {
		gmailLoginPage.typeEmailAndSubmit(login);
	}

	public void typePasswordAndSubmit(String password) {
		gmailLoginPage.typePasswordAndSubmit(password);
	}

	public void redirectToPage(String url) {
		gmailLoginPage.redirectToPage(url);
	}

	public boolean isURLCorrect(String expectedURL) {
		return gmailLoginPage.isURLCorrect(expectedURL);
	}
}
