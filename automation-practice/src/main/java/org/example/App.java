package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static class DriverFactory {

        public static WebDriver createDriver() {
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();

            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", ConfigurationReader.getProperty("chrome.driver.path"));
                    return new ChromeDriver();

                case "edge":
                    System.setProperty("webdriver.edge.driver", ConfigurationReader.getProperty("edge.driver.path"));
                    return new EdgeDriver();

                default:
                    throw new IllegalArgumentException("⚠️ Unsupported browser: " + browser);
            }
        }
    }
}
