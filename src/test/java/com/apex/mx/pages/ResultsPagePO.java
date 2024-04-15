package com.apex.mx.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class ResultsPagePO extends PageObjectEngine{

    @FindBy(xpath="//*[@class=\"card-title a-card-description\"]")
    private List<WebElement> nameProductsList;


    @FindBy(className = "icon-zoom")
    private  WebElement searchButton;


    @FindBy(xpath = "//*[@class=\"o-nullproduct-title-query\"]")
    private WebElement noItemFoundNotification;


    @FindBy(xpath = "//*[@class=\"o-nullproduct-title-query\"]/b")
    private WebElement noItemNameFoundNotification;

}
