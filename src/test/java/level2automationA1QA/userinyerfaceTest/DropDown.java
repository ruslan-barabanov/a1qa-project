package level2automationA1QA.userinyerfaceTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DropDown {
    WebDriver driver;
    String triggerLocator = "//div[@class='dropdown__field']";
    String optionLocatorByText = "//div[@class='dropdown__list-item' and contains(text(),'%s') ]";

    public DropDown(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.findElement(By.xpath(triggerLocator)).click();
    }

    public void selectOptionByText(String text) {
        open();
        driver.findElement(By.xpath(String.format(optionLocatorByText,text))).click();
    }
}
