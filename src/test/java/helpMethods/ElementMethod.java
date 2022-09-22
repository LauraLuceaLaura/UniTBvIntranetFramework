package helpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ElementMethod {

    public WebDriver driver;

    public ElementMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element){
        element.click();
    }
    public void fillElement(WebElement element, String value ){
        element.sendKeys(value);

    }
    public void hoverElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void validateElementText(WebElement element, String value){
        String actualError = element.getText();
        Assert.assertEquals(actualError,value);
    }

}