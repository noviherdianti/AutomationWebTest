package platform.web.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import platform.web.modules.AbstractPage;

public class HomePage extends AbstractPage {

    private String contentId = "";

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private static WebElement element = null;
    @FindBy(xpath = "//*[@id=\"login\"]/form/div[3]/input[3]")
    protected WebElement signinBtn;
    @FindBy(xpath = "//*[@id=\"login_field\"]")
    protected WebElement emailField;
    @FindBy(id = "password")
    protected WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"user-links\"]/li[2]/details/summary")
    protected WebElement dropDownMenu;

    @FindBy(xpath = "//*[@id=\"user-links\"]/li[2]/details/details-menu/a[3]")
    protected WebElement newGistBtn;

    @FindBy(xpath = "//*[@id=\"gists\"]/div[2]/div/div[1]/div[1]/input[2]")
    protected WebElement gistNameField;

    @FindBy(xpath = "//*[@id=\"gists\"]/input")
    protected WebElement gistDesc;

    @FindBy(id = "line-wrap-mode")
    protected WebElement wrapGist;

    @FindBy(xpath = "//*[@id=\"new_gist\"]/div/div[2]/button[1]")
    protected WebElement submitGistBtn;

    @FindBy(xpath = "//*[@id=\"gist-pjax-container\"]/div[1]/div/div[1]/ul/li[1]/a")
    protected WebElement editGistBtn;

    @FindBy(xpath = "/html/head/meta[41]")
    private static WebElement contentBtn;


//    @FindBy(xpath = "//*[@id=\"edit_gist_"+contentId+"\"]/div/div[2]/button")
//    private static WebElement updatePublicGistBtn;


    @FindBy(xpath = "//*[@id=\"gist-pjax-container\"]/div[1]/div/div[1]/ul/li[2]/form/button")
    protected WebElement deleteGistBtn;
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    protected WebElement okPopupBtn;

    @FindBy(xpath = "//*[@id=\"gist-pjax-container\"]/div[2]/div[1]/div/h3")
    protected WebElement listGits;

//    ===================

    public void clickBtnSignIn(String email, String password) {
        waitForVisibilityOf(emailField);
        inputTextToElement(emailField, email);
        inputTextToElement(passwordField, password);
        isElementPresentVerifyclick(signinBtn);
    }

    public void clickDropdownMenu() {
        isElementPresentVerifyclick(dropDownMenu);
    }

    public void clickNewGist() {
        isElementPresentVerifyclick(newGistBtn);
    }

    public void inputNewGistField() {
        wrapGist.sendKeys(Keys.TAB, "TestGist");
    }

    public void inputGistDesc() {
//        waitForVisibilityOf(gistDesc);
        inputTextToElement(gistDesc, "test Gist 1");
    }

    public void clickSubmitGistBtn() {
        isElementPresentVerifyclick(submitGistBtn);
    }


    public void getContentBtn() {
        contentId = contentBtn.getAttribute("content");
        updateGist(webDriver, contentId).click();

    }

    public void inputUpdateNewGistField() {
        inputTextToElement(gistNameField, " Update");

    }

    public void clickNewGistBtn() {
        isElementPresentVerifyclick(newGistBtn);
    }

    public void clickEditGistBtn() {
        isElementPresentVerifyclick(editGistBtn);
    }

    public static WebElement updateGist(WebDriver driver, String contentId) {
        element = driver.findElement(By.xpath("//*[@id=\"edit_gist_"+contentId+"\"]/div/div[2]/button"));
        return element;
//*[@id="edit_gist_93655384"]/div/div[2]/button
    }

    public void clickUpdateGistBtn() {
        getContentBtn();


//        updatePublicGistBtn.click();
    }

    public void clickDeleteGistBtn() {
        isElementPresentVerifyclick(deleteGistBtn);
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
    }

    public void clickUsernameGist() {
        isElementPresentVerifyclick(listGits);
    }


}
