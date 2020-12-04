package level2automationA1QA.userinyerfaceTest.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ThreePageUserInYerFace extends Form {
    /**
     * Constructor with parameters
     *
     * @param locator
     * @param name
     */
    public ThreePageUserInYerFace(By locator, String name) {
        super(locator, name);
    }

    private final ICheckBox unselectAll = getElementFactory().getCheckBox(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[21]/div[1]/span[1]/label[1]/span[1]/span[1]"), "unselect all");
    private final ILink photoUpload = getElementFactory().getLink(By.xpath("//a[@class='avatar-and-interests__upload-button']"),"photo upload");
    private final IButton nextButton3 = getElementFactory().getButton(By.xpath("//button[@class='button button--stroked button--white button--fluid']"), "next");
    public IButton getNextButton() {
        return nextButton3;}
    public ICheckBox clickCheck() {
        return unselectAll;
    }

    public ILink getPhotoUpload(){
        return photoUpload;
    }


    public void get3Interests() {
        List<WebElement> allInterests = AqualityServices.getBrowser().getDriver().findElements(By.xpath("//div[@class='avatar-and-interests__interests-list__item']"));
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            AqualityServices.getBrowser().getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div/div[1]/div/div[3]/div/div[" + random.nextInt(18) + "]/div/span[1]/label/span")).click();
        }
    }
}

