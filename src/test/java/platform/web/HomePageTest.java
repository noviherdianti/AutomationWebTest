package platform.web;

import common.BaseWebTest;
import org.junit.Test;

public class HomePageTest extends BaseWebTest {

    @Test
    public void HM_01() {
        steps("Login Github");
        homePage.clickBtnSignIn("herdiantin@gmail.com","novi1190");
        steps("As a user, I want to create a public gist.");
        homePage.clickDropdownMenu();
        homePage.clickNewGist();
        homePage.inputGistDesc();
        homePage.inputNewGistField();
        homePage.clickSubmitGistBtn();

        steps("Edit Gist from list");
        homePage.clickEditGistBtn();
        homePage.inputUpdateNewGistField();
        homePage.clickUpdateGistBtn();

        steps("Delete Gist");
        homePage.clickDeleteGistBtn();

        steps("See List Gist");
        homePage.clickUsernameGist();
}

}
