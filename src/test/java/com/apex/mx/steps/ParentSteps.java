package com.apex.mx.steps;

import com.apex.mx.engine.WebDriverEngine;
import com.apex.mx.spring.CucumberContext;
import com.apex.mx.spring.PropertiesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes={CucumberContext.class, PropertiesContext.class})
public class ParentSteps {

	@Autowired
	protected WebDriverEngine webDriverEngine;

	
}
