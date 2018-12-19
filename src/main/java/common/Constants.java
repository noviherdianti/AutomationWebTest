package common;


public class Constants {

    /**
     * Default Constant value for web
     */
    public static final String DEFAULT_WEB_TO_TEST = "Google";
    public static final String DEFAULT_WEBDRIVER_NAME = "Chrome";
    public static final String DEFAULT_CHROME_PROPERTY = "webdriver.chrome.driver";
    public static final String DEFAULT_PATH_CHROME_DRIVER_MAC = System.getProperty("user.dir") + "/src/test/resources/mac/chromedriver2";
    public static final String DEFAULT_PATH_CHROME_DRIVER_WINDOWS = System.getProperty("user.dir") + "/src/test/resources/windows/chromedriver";
    public static final String DEFAULT_WEB_URL = "https://github.com/login";
    public static final int DEFAULT_TIMEOUT = 10;
}
