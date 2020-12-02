package level2automationA1QA.userinyerfaceTest;

import aquality.selenium.browser.AqualityServices;
import level2automationA1QA.BaseTest;
import level2automationA1QA.userinyerfaceTest.pages.FirstPageUserInYerFace;
import level2automationA1QA.userinyerfaceTest.pages.ThreePageUserInYerFace;
import level2automationA1QA.userinyerfaceTest.pages.TwoPageUserInYerFace;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserInYerFaceTest extends BaseTest {

    FirstPageUserInYerFace firstPageUserInYerFace = new FirstPageUserInYerFace(By.xpath("//a[game.html']"), "Plus");
    TwoPageUserInYerFace twoPageUserInYerFace = new TwoPageUserInYerFace(By.xpath("//div//input[@placeholder='Choose Password']"), "password");
    ThreePageUserInYerFace threePageUserInYerFace = new ThreePageUserInYerFace(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[21]/div[1]/span[1]/label[1]/span[1]/span[1]"), "unselect all");
    String randomString = new GenerateRandomString().randomString();
    DropDown dropDown = new DropDown(AqualityServices.getBrowser().getDriver());

    @Test
    public void getTitleOfPage() {
        Assert.assertEquals(getBrowser().getCurrentUrl(), DEFAULT_URL);
    }

    @Test
    public void get() {
        firstPageUserInYerFace.getGamePage();
        Assert.assertEquals(getBrowser().getCurrentUrl(), "https://userinyerface.com/game.html");
        getBrowser().waitForPageToLoad();

        Assert.assertEquals(twoPageUserInYerFace.getNumberOfCard(), "1 / 4");
        twoPageUserInYerFace.getPasswordText().clearAndType(randomString + "абв");
        twoPageUserInYerFace.getEmailText().clearAndType("ruslanабв");
        twoPageUserInYerFace.getDomainText().clearAndType("123");
        dropDown.selectOptionByText(".org");
        twoPageUserInYerFace.getAcceptCheckBox().click();
        twoPageUserInYerFace.getNextButton().clickAndWait();

        Assert.assertEquals(twoPageUserInYerFace.getNumberOfCard(), "2 / 4");
        threePageUserInYerFace.clickCheck().click();
        threePageUserInYerFace.get3Interests();
        threePageUserInYerFace.getPhotoUpload();
//        ChromeOptions options = new ChromeOptions();
//        options.addExtensions(Paths.get("C:\\Users\\Ruslan\\Pictures\\cat_avatar.jpg").toFile());
//        ChromeDriver driver = new ChromeDriver(options);
//        threePageUserInYerFace.getPhotoUpload().getAttribute("value");
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
        WebDriverWait wait = new WebDriverWait(AqualityServices.getBrowser().getDriver(),10);
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
