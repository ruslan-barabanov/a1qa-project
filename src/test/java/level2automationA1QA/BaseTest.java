package level2automationA1QA;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.elements.interfaces.IElementFactory;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import theinternet.TheInternetPage;

import java.util.concurrent.TimeUnit;

import static automationpractice.Constants.URL_AUTOMATIONPRACTICE;

public abstract class BaseTest {
    protected static final String DEFAULT_URL = "https://userinyerface.com/game.html%20target=";
    protected static final String GAME_URL = "https://userinyerface.com/game.html";


    protected final Dimension defaultSize = new Dimension(2000, 768);
    protected final IElementFactory elementFactory;

    protected BaseTest() {
        elementFactory = AqualityServices.getElementFactory();
    }

    @BeforeMethod
    protected void beforeMethod() {
        AqualityServices.getBrowser().goTo(DEFAULT_URL);
        getBrowser().setWindowSize(defaultSize.width, defaultSize.height);
        AqualityServices.getBrowser().getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterTest() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }

    protected void navigate(TheInternetPage page) {
        getBrowser().goTo(page.getAddress());
    }

    protected Browser getBrowser() {
        return AqualityServices.getBrowser();
    }

}
