package level2automationA1QA.userinyerfaceTest;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import level2automationA1QA.BaseTest;
import level2automationA1QA.userinyerfaceTest.pages.FirstPageUserInYerFace;
import level2automationA1QA.userinyerfaceTest.pages.ThreePageUserInYerFace;
import level2automationA1QA.userinyerfaceTest.pages.TwoPageUserInYerFace;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class UserInYerFaceTest extends BaseTest {
    private Properties properties = new Properties();
    FirstPageUserInYerFace firstPageUserInYerFace = new FirstPageUserInYerFace(By.xpath("//a[game.html']"), "Plus");
    TwoPageUserInYerFace twoPageUserInYerFace = new TwoPageUserInYerFace(By.xpath("//div//input[@placeholder='Choose Password']"), "password");
    ThreePageUserInYerFace threePageUserInYerFace = new ThreePageUserInYerFace(By.xpath("//body/div[@id='app']"), "unselect all");
    String randomString = new GenerateRandomString().randomString();
    Browser browser = AqualityServices.getBrowser();
    DropDown dropDown = new DropDown(browser.getDriver());
    AutoIdTest autoIdTest = new AutoIdTest();

    @Test
    public void getTitleOfPage() {
        Assert.assertEquals(getBrowser().getCurrentUrl(), DEFAULT_URL);
    }

    @Test
    public void testAuthorisationAndAddPhoto() throws IOException, InterruptedException {
        properties.load(ClassLoader.getSystemResourceAsStream("userIn.properties"));
        String pass = properties.getProperty("pass.path");
        String email = properties.getProperty("email.path");
        String domain = properties.getProperty("domain.path");
        String option = properties.getProperty("option.path");


        firstPageUserInYerFace.getGamePage();
        Assert.assertEquals(getBrowser().getCurrentUrl(), "https://userinyerface.com/game.html");
        getBrowser().waitForPageToLoad();

        Assert.assertEquals(twoPageUserInYerFace.getNumberOfCard(), "1 / 4");
        twoPageUserInYerFace.getPasswordText().clearAndType(randomString + pass);
        twoPageUserInYerFace.getEmailText().clearAndType(email);
        twoPageUserInYerFace.getDomainText().clearAndType(domain);
        dropDown.selectOptionByText(option);
        twoPageUserInYerFace.getAcceptCheckBox().click();
        twoPageUserInYerFace.getNextButton().clickAndWait();

        Assert.assertEquals(twoPageUserInYerFace.getNumberOfCard(), "2 / 4");
        threePageUserInYerFace.clickCheck().click();
        threePageUserInYerFace.get3Interests();
        threePageUserInYerFace.getPhotoUpload().click();
        autoIdTest.addMyPhoto();
        twoPageUserInYerFace.getNextButton3().clickAndWait();
        Assert.assertEquals(twoPageUserInYerFace.getNumberOfCard(), "3 / 4");
    }

    @Test
    public void closeWindowHelp() {
        firstPageUserInYerFace.getGamePage();
        twoPageUserInYerFace.getHelpButton().clickAndWait();
        Assert.assertNotNull(twoPageUserInYerFace.getHiddenOfHelp());
    }

    @Test
    public void clickAcceptCookie() {
        firstPageUserInYerFace.getGamePage();
        twoPageUserInYerFace.getCookieButton().clickAndWait();
        int cookie = twoPageUserInYerFace.getCookieClass().size();
        Assert.assertEquals(cookie, 0);
    }

    @Test
    public void getStartTimer() {
        firstPageUserInYerFace.getGamePage();
        String startTimer = twoPageUserInYerFace.getTimer().getText();
        Assert.assertEquals(startTimer, "00:00:00");
    }
}
