package com.apex.mx.steps;

import com.apex.mx.services.ResultsPageService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class ResultsPageSteps extends StepEngine{

    @Autowired
    private ResultsPageService resultsPageService;

    @Then("^I should see result page visible$")
    public void validateVisibleResultPage(){
        Assert.isTrue(resultsPageService.isVisibleArticlesResults(), "Result page is not visible");
    }

    @And("^I should see results that contains text \"([^\"]*)\"$")
    public void iShouldSeeResultsThatContainsText(String productName) throws Throwable {
        Assert.isTrue(resultsPageService.allArticlesNamesContains(productName), String.format("All the articles doest contains text ", productName));
    }

    @Then("^I should be notified that there are no articles with text \"([^\"]*)\"$")
    public void iShouldBeNotifiedThatThereAreNoArticlesWithText(String productName) throws Throwable {
        Assert.isTrue(resultsPageService.isvisibleNoArticleNotification(productName), "No items notifications validation is wrong");
    }

    @And("^I should see the first result with all these words \"([^\"]*)\"$")
    public void iShouldSeeTheFirstResultWithAllTheseWords(String productName) throws Throwable {
        Assert.isTrue(!resultsPageService.doesTheResultContainsWords(productName), "Name of element doest contains all parameters");
    }
}
