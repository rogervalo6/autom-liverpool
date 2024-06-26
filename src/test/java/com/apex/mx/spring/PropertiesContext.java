package com.apex.mx.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesContext {
	
	@Value("${selenium.screenshotOnFailure}")
	private String screenshotOnFailure;
	
	@Bean("screenshotOnFailure")
	public boolean takeScreenshotOnFailure() {
		return Boolean.parseBoolean(screenshotOnFailure);
	}
	
	@Value("${selenium.screenshotDestinationFolder}")
	private String screenshotDestinationFolder;
	
	@Bean("screenshotDestinationFolder")
	public String getScreenshotDestinationFolder() {
		return screenshotDestinationFolder;
	}
	
	@Value("${selenium.webbrowser}")
	private String webbrowser;
	
	@Bean("webbrowser")
	public String getWebbrowser() {
		return webbrowser;
	}

	@Value("${engine.url}")
	private String url;

	@Bean("url")
	public String getUrl() {
		return url;
	}

	@Value("${engine.waitTime}")
	private String waitTime;

	@Bean("waitTime")
	public String getTimewait() {
		return waitTime;
	}

}
