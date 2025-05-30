package com.epam.framework.hooks;

import com.epam.framework.base.DriverManager;
import com.epam.framework.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

        @Before
        public void setUp() {
            DriverFactory.getInstance().getDriver();
        }

        @After
        public void tearDown(Scenario scenario) {
            // If NOT ProfileFeature, quit after each
            if (!scenario.getSourceTagNames().contains("@ProfileFeature")) {
                DriverFactory.getInstance().quitDriver();
            }
            System.out.println("After executed");
        }

        @AfterAll
        public static void tearDownAfterAll() {
            // AfterAll ONLY for ProfileFeature
            DriverFactory.getInstance().quitDriver();
            System.out.println("AfterAll executed");
        }
    }
