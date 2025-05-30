package com.epam.framework.factory;

import io.cucumber.java.it.E;
import io.cucumber.java.it.Ed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

    private static DriverFactory instance;
    private WebDriver driver;

    private DriverFactory(){

    }
    public static DriverFactory getInstance(){
        if(instance == null){
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
//            ChromeOptions  options = new ChromeOptions();
            EdgeOptions options=new EdgeOptions();
            options.addArguments("--start-maximized");
//            driver = new ChromeDriver(options);
            driver=new EdgeDriver(options);
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            System.out.println("quitting");
            driver = null;
        }
    }
}
