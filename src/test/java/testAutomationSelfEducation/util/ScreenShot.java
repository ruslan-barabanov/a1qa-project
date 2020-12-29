package testAutomationSelfEducation.util;

import aquality.selenium.browser.AqualityServices;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class ScreenShot {
    WebDriver driver;

    @Test
    public void testScreen() throws IOException, URISyntaxException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.tut.by/");
        String screenshot = ((TakesScreenshot) driver).
                getScreenshotAs(OutputType.BASE64);
        System.out.println(screenshot);

        URIBuilder ub = new URIBuilder();
        ub.setScheme("http").setHost("localhost").setPort(8080).setPath("/api/test/put/attachment").
                setParameter("testId", "351").setParameter("content", screenshot).
                setParameter("contentType", "image/png");
        final Content postResultForm = Request.Post(ub.build())
                .execute().returnContent();
        String token = postResultForm.asString();
        System.out.println(token);
    }
}