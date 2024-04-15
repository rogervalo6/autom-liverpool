package com.apex.mx.engine;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverEngine {

    @Getter
    private  static WebDriver webDriver;

    @Getter
    private static WebDriverWait webDriverWait;

    @Getter
    private static boolean screenshotOnFailure;

    private static final String BASE_URL="https://www.liverpool.com.mx";

    private static String url;

    public WebDriverEngine(WebDriver webDriver, WebDriverWait webDriverWait,
                           String url, boolean screenshotOnFailure) {
        WebDriverEngine.webDriver = webDriver;
        WebDriverEngine.webDriverWait = webDriverWait;
        WebDriverEngine.url = url;
        WebDriverEngine.screenshotOnFailure = screenshotOnFailure;
    }

    public static void openHomePage(){
        webDriver.get(String.format(BASE_URL, url));
    }
}
