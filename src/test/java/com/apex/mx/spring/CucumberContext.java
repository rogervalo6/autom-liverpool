package com.apex.mx.spring;

import com.apex.mx.beans.ChromeWebDriver;
import com.apex.mx.beans.FirefoxWebDriver;
import com.apex.mx.engine.WebDriverEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.time.Duration;

@Configuration
@ContextConfiguration(classes={PropertiesContext.class})
@ComponentScan({"com.apex.mx.services", "com.apex.mx.pages"})
@Service
public class CucumberContext {
	
	@Autowired 
	private String webbrowser;

	@Autowired
	private String url;

	@Autowired
	private String waitTime;

	@Autowired
	private boolean screenshotDestinationFolder;


	@Bean(name="webdriver", destroyMethod="close")
	public WebDriver getWebDriver() {
		WebDriver webdriver = null;
		switch (webbrowser) {
			case "firefox":
				webdriver = new FirefoxWebDriver();
				break;
			
			case "chrome":
				webdriver = new ChromeWebDriver();
				break;
		}
		return webdriver; 
	}
	
	@Bean("wait")
	public WebDriverWait getWebDriverWait() {
		return new WebDriverWait(getWebDriver(), Duration.ofSeconds(Integer.parseInt(waitTime)));
	}

	@Bean
	public WebDriverEngine getWebDriverEngine(){
		return new WebDriverEngine(getWebDriver(), getWebDriverWait(), url, screenshotDestinationFolder);
	}

}
