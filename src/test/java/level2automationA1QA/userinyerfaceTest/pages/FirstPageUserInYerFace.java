package level2automationA1QA.userinyerfaceTest.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FirstPageUserInYerFace extends Form {
    /**
     * Constructor with parameters
     *
     * @param locator
     * @param name
     */
    public FirstPageUserInYerFace(By locator, String name) {
        super(By.id("app"), "First Page");
    }

    private final IButton link = getElementFactory().getButton(By.xpath("//a[@href='/game.html']"), "Plus");


    public void getGamePage() {
        link.click();
    }

}
