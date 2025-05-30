package com.epam.framework.base;

import com.epam.framework.config.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverManager {
    public static final ThreadLocal<WebDriver> driverThread=new ThreadLocal<>();

    public static WebDriver getDriver(){
        if (driverThread.get() == null) {
            String edgeDriverPath = ConfigurationReader.getProperty("edge.driver.path");
            System.setProperty("webdriver.edge.driver", edgeDriverPath); // <-- Set correct path here
            WebDriver driver = new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driverThread.set(driver);
        }
        return driverThread.get();
    }
    public static void quitDriver(){
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.remove();
        }

    }

}
