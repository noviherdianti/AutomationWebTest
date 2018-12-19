package common;

import org.junit.After;
import org.junit.Before;
import platform.web.pages.HomePage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseWebTest extends DriverBuilder {
    protected HomePage homePage;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    public BaseWebTest() {
    }

    @Before()
    public void setUp() {
        super.setPlatform("Web");
        super.setWebDriver();
        homePage = new HomePage(getWebDriver());
        System.out.println("=========================================================");
        System.out.println("Project      : Testing Web Automation");
        System.out.println("Date         : "+ dateFormat.format(date));
        System.out.println("URL          : "+ Constants.DEFAULT_WEB_URL);
        System.out.println("Driver Name  : "+ Constants.DEFAULT_WEBDRIVER_NAME);
        System.out.println("=========================================================");
    }

    @After()
    public void tearDown(){
        getWebDriver().quit();
    }
}
