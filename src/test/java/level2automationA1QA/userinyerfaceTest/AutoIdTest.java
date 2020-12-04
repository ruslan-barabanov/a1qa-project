package level2automationA1QA.userinyerfaceTest;

import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class AutoIdTest {

    public void addMyPhoto() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("C://Users//Ruslan//Pictures//FileUploadScript.exe");
        Thread.sleep(7000);
    }
}
