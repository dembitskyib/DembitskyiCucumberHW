package com.epam.lab.cucumberHW;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/epam/lab/cucumberHW", glue = { "com.epam.lab.cucumberHW.steps" })

public class LoginTestRunner {

}
