package com.apex.mx;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@smoke",
        features = {"src/test/resources/features"},
        //glue = "com.apex.mx.steps",
        plugin = {
                "pretty",
                "html:target/cucumber"
        })

public class CucumberRunnerTest {

}
