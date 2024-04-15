package com.apex.mx.services;

import com.apex.mx.constants.ResultsPageConstants;
import com.apex.mx.pages.ResultsPagePO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service
public class ResultsPageServiceImpl extends ResultsPageService{

    private final static Logger logger = LoggerFactory.getLogger(ResultsPageServiceImpl.class);


    private ResultsPagePO resultsPage;

    @Override
    public boolean isVisibleArticlesResults() {
        resultsPage = new ResultsPagePO();
        resultsPage.getWebDriverWait().until(e -> resultsPage.getNameProductsList().stream().allMatch(WebElement::isDisplayed));
        return resultsPage.getNameProductsList().stream().allMatch(WebElement::isDisplayed);
    }

    @Override
    public boolean allArticlesNamesContains(String nameProduct) {
        return new ResultsPagePO().getNameProductsList().stream().
                allMatch(e -> e.getText().toLowerCase().contains(nameProduct.toLowerCase()));
    }

    @Override
    public boolean isvisibleNoArticleNotification(String productName) {
        resultsPage = new ResultsPagePO();
        resultsPage.getWebDriverWait().until(d -> resultsPage.getNoItemFoundNotification().isDisplayed());
        String notification = resultsPage.getNoItemFoundNotification().
                getText();
        return notification.contains(ResultsPageConstants.NO_ITEM_FOUND_NOTIFICATION_TEXT) &&
                notification.contains(productName);
    }

    @Override
    public boolean doesTheResultContainsWords(String productName) {
        resultsPage = new ResultsPagePO();
        resultsPage.getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(resultsPage.getNameProductsList()));
        String [] separatedText = productName.split(" ");
        for(String elements: separatedText){
            if(!resultsPage.getNameProductsList().get(0).getText().
                    toLowerCase().contains(elements.toLowerCase())){
                return false;
            }
        }
        return true;
    }
}
