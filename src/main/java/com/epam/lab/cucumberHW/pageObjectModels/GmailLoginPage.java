package com.epam.lab.cucumberHW.pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.lab.cucumberHW.pageElements.Button;
import com.epam.lab.cucumberHW.pageElements.DivTextInput;
import com.epam.lab.cucumberHW.utils.CustomFieldDecorator;

public class GmailLoginPage extends GmailPage {
	@FindBy(xpath = "//input[@type = 'email']")
	private DivTextInput emailInput;
	@FindBy(xpath = "//div[@id = 'identifierNext']//span")
	private Button emailSubmit;
	@FindBy(name = "password")
	private DivTextInput passwordInput;
	@FindBy(css = "#passwordNext")
	private Button passwordSubmit;

	public GmailLoginPage(WebDriver driver, int pageUpdateTimeOut) {
		super(driver, pageUpdateTimeOut);
		this.pageUpdateTimeOut = pageUpdateTimeOut;
		PageFactory.initElements(new CustomFieldDecorator(driver), this);
	}

	public void typeEmailAndSubmit(String login) {
		isURLCorrect("signin");
		emailInput.type(login);
		emailSubmit.click(driver, pageUpdateTimeOut);
	}

	public GmailHomePage typePasswordAndSubmit(String password) {
		passwordInput.sendKeys(password);
		passwordSubmit.clickWithJs(driver, pageUpdateTimeOut);
		return new GmailHomePage(driver, pageUpdateTimeOut);
	}
}
