package com.apex.mx.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HomepagePO extends PageObjectEngine{

    @Getter
    @FindBy(id="mainSearchbar")
    private WebElement searchField;

    @Getter
    @FindBy(className = "icon-zoom")
    private  WebElement searchButton;

}
