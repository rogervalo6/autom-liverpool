package com.apex.mx.steps;

import com.apex.mx.engine.WebDriverEngine;
import com.apex.mx.services.HomePageService;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePageSteps extends StepEngine {

    @Autowired
    private HomePageService homePageService;

    @Given("^I am on the search engine home page$")
    public void i_am_on_the_search_engine_home_page() throws Throwable {
        WebDriverEngine.openHomePage();
    }

    @When("^I type \"([^\"]*)\" on search text field$")
    public void iTypeOnSearchTextField(String article) throws Throwable {
        homePageService.addTextToSearchField(article);
    }

    @When("^I click on search button$")
    public void clickOnSearchButton() throws InterruptedException {
        homePageService.clickOnSearchButton();
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            if (WebDriverEngine.isScreenshotOnFailure()) {
                Date now = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDHHmmss");
                String timestamp = sdf.format(now);

                File srcFile = ((TakesScreenshot) WebDriverEngine.getWebDriver()).getScreenshotAs(OutputType.FILE);
                File destFile = new File("./target/cucumber/errors/"
                        + timestamp + "_"
                        + scenario.getName().replaceAll(" ", "_") + ".png");
                FileUtils.moveFile(srcFile, destFile);
                //logger.info("Screenshot taken: " + destFile.getAbsolutePath());
            }
        }
    }
}
