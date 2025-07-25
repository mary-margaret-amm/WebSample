package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature", glue = "com.StepDefinition", dryRun = false,
                 //tags = "@sanity123",
                // monochrome = true,
                // publish = true

                plugin = {
                                "json:target/cucumber-report/cucumber.json",
                                "html:target/cucumber-report/cucumber.html"
                })
public class RunnerClass {

}
