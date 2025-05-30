package com.epam.framework.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "com.epam.framework.stepdefs.ui",
                "com.epam.framework.hooks"         // <-- Add this!
        },
        plugin = {"pretty", "html:target/cucumber-report.html"              // Optional HTML report
        },
        monochrome = true,                             // Clean console output
        dryRun = false                                // Set to true to check step defs without runnin
                // Run tests based on tags
)
public class TestRunner {
    // This class doesn't need any code, it just serves as the entry point for Cucumber tests.
}
