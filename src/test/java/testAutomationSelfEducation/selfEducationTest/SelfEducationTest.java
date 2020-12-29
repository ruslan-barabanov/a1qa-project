package testAutomationSelfEducation.selfEducationTest;


import level2automationA1QA.userinyerfaceTest.GenerateRandomString;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testAutomationSelfEducation.BaseTest;
import testAutomationSelfEducation.pages.ProjectsPage;

import java.io.IOException;
import java.net.URISyntaxException;


public class SelfEducationTest extends BaseTest {
    ProjectsPage projectsPage = new ProjectsPage(By.xpath("//button[@class='btn btn-xs btn-primary pull-right']"), "button add");
    GenerateRandomString randomName = new GenerateRandomString();

    @Test
    public void newPostRequestGetToken() throws IOException {

        String token = fluentApi.sendPostGetToken();

        System.out.println(token);

        Cookie actualTokenCookie = new Cookie("tokenCookie", token);
        getBrowser().getDriver().manage().addCookie(actualTokenCookie);
        Cookie expectedTokenCookie = getBrowser().getDriver().manage().getCookieNamed("tokenCookie");
        Assert.assertEquals(actualTokenCookie, expectedTokenCookie);
        getBrowser().getDriver().navigate().refresh();
        System.out.println();
        String s = getBrowser().getDriver().findElement(By.xpath("//span[text()='Version: 0']")).getText();
        System.out.println(s);
    }

    @Test
    public void getListNextage() {

    }

    @Test
    public void addNewProject() throws IOException, URISyntaxException {
        String nameProject = randomName.randomString();
        projectsPage.getAddButton().click();
        getBrowser().getDriver().switchTo().defaultContent();
        String myNameProject = "My Project " + nameProject;
        getBrowser().getDriver().findElement(By.xpath("//input[@id='projectName']")).sendKeys(myNameProject + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(getBrowser().getDriver(), 10);
        WebElement dynamicElement = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
        getBrowser().getDriver().navigate().refresh();
        getBrowser().getDriver().switchTo().defaultContent();
        String actualName = getBrowser().getDriver().findElement(By.xpath("//a[text()='" + myNameProject + "']")).getText();
        System.out.println(actualName);
        Assert.assertEquals(myNameProject, actualName);

        getBrowser().getDriver().findElement(By.xpath("//a[text()='" + myNameProject + "']")).click();

        String screenshot = ((TakesScreenshot) getBrowser().getDriver()).
                getScreenshotAs(OutputType.BASE64);

        String id = fluentApi.sendPostTestId(actualName);
        System.out.println(id);
        fluentApi.sendScreen(id,screenshot);
        String actualResult = getBrowser().getDriver().findElement(By.xpath("//a[@href='testInfo?testId="+id+"']")).getText();
        Assert.assertEquals(actualResult,"testForMe");

    }

    @Test
    public void addTestInMyProject() throws IOException, URISyntaxException {
//        String id = fluentApi.sendPostTestId();
//        System.out.println(id);

    }
}
