package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverBuilder {
    private static WebDriver webDriver = null;
    private static String platform;
    private static String nativePlatform;
    private File appDir;
    private File app;
//    private static int step = 1;

    public void setPlatform(String platform){
        this.platform = platform;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(){
        switch (System.getProperty("os.name").toLowerCase()) {
            case "mac" : System.setProperty(Constants.DEFAULT_CHROME_PROPERTY, Constants.DEFAULT_PATH_CHROME_DRIVER_MAC);
                break;
            case "windows" : System.setProperty(Constants.DEFAULT_CHROME_PROPERTY, Constants.DEFAULT_PATH_CHROME_DRIVER_WINDOWS);
                break;
        }
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/mac/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        webDriver.get(Constants.DEFAULT_WEB_URL);
        webDriver.manage().window();
    }

    private static int step;
    public void steps(String message){
        System.out.println(step + ". " + message);
        step = (step + 1);
    }
}
