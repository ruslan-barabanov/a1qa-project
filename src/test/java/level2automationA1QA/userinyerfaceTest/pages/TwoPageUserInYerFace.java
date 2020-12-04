package level2automationA1QA.userinyerfaceTest.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TwoPageUserInYerFace extends Form {
    /**
     * Constructor with parameters
     *
     * @param locator
     * @param name
     */

    public TwoPageUserInYerFace(By locator, String name) {
        super(locator, name);
    }

    private final ITextBox textBoxPassword = getElementFactory().getTextBox(By.xpath("//div//input[@placeholder='Choose Password']"), "password");
    private final ITextBox textBoxEmail = getElementFactory().getTextBox(By.xpath("//div//input[@placeholder='Your email']"), "email");
    private final ITextBox textBoxDomain = getElementFactory().getTextBox(By.xpath("//div//input[@placeholder='Domain']"), "domain");
    private final IComboBox comboBox = getElementFactory().getComboBox(By.className("dropdown__field"), "drop down");
    private final ICheckBox checkBox = getElementFactory().getCheckBox(By.xpath("//span[@class='icon icon-check checkbox__check']"), "accept");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//a[@class='button--secondary']"), "next");
    private final IButton helpButton = getElementFactory().getButton(By.xpath("//button[@class='button button--solid button--blue help-form__send-to-bottom-button']"), "button help");
    private final IButton cookieButton = getElementFactory().getButton(By.xpath("//button[@class='button button--solid button--transparent']"), "button cookie");
    private final List<WebElement> cookieClass = AqualityServices.getBrowser().getDriver().findElements(By.xpath("//div[@class='cookies']"));
    private final IElement timer = getElementFactory().getLabel(By.xpath("//div[@class='timer timer--white timer--center']"), "timer");
    private final IElement numberOfCard = getElementFactory().getTextBox(By.xpath("//div[@class='page-indicator']"), "number");
    private final IElement hiddenOfHelp = getElementFactory().getLabel(By.xpath("//div[@class='help-form is-hidden']"), "hidden form");
    private final IButton nextButton3 = getElementFactory().getButton(By.xpath("//button[@class='button button--stroked button--white button--fluid']"), "next");
    public IButton getNextButton3() {
        return nextButton3;}
    public List<WebElement> getCookieClass() { return cookieClass;}

    public IElement getHiddenOfHelp() {
        return hiddenOfHelp;
    }

    public String getNumberOfCard() {
        return numberOfCard.getText();
    }

    public ITextBox getPasswordText() {
        return textBoxPassword;
    }

    public ITextBox getEmailText() {
        return textBoxEmail;
    }

    public ITextBox getDomainText() {
        return textBoxDomain;
    }

    public IComboBox getDropDown() {
        return comboBox;
    }

    public ICheckBox getAcceptCheckBox() {
        return checkBox;
    }

    public IButton getNextButton() {
        return nextButton;
    }

    public IButton getHelpButton() {
        return helpButton;
    }

    public IButton getCookieButton() {
        return cookieButton;
    }

    public IElement getTimer() {
        return timer;
    }
}
