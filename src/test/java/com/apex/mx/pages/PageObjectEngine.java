package com.apex.mx.pages;

import com.apex.mx.engine.WebDriverEngine;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


@Getter
public class PageObjectEngine {

    public WebDriver webdriver;

    public WebDriverWait webDriverWait;

    protected PageObjectEngine() {
        this.webdriver = WebDriverEngine.getWebDriver();
        this.webDriverWait = WebDriverEngine.getWebDriverWait();
        PageFactory.initElements(webdriver, this);
    }
}
