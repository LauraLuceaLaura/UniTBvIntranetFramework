package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import shareData.ShareData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UniTBvPage extends BasePage {

    public UniTBvPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='cookie-consent-footer-content']//button[contains(@class,'cookie-consent')]")
    private WebElement waitForCookie;

    @FindBy(css = "ul>li[id='iceMenu_773']")
    private WebElement waitForPlatformeElement;

    public void prepareAccess() throws InterruptedException {
        acceptCookie();
        verifyUniTBvPageTitle();
        accessIntranetPlatform();
        switchTabFocus();
    }

    public void acceptCookie()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getWaitForCookie()));
        WebElement clickOk = driver.findElement((By) getWaitForCookie());
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", clickOk);
    }

    public void verifyUniTBvPageTitle()
    {
        String actualTitleUniTBv = driver.getTitle();
        String expectedTitleUniTBv = "UniTBv";
        Assert.assertEquals(expectedTitleUniTBv, actualTitleUniTBv);
    }

    public void accessIntranetPlatform() throws InterruptedException {
        Thread.sleep(5);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getWaitForPlatformeElement()));
        WebElement hoverOverPlatforme = driver.findElement((By) getWaitForPlatformeElement());
        Actions builder = new Actions(driver);
        Thread.sleep(1000);
        builder.moveToElement(hoverOverPlatforme).perform();
        Actions action = new Actions(driver);
        Thread.sleep(1000);
        action.moveToElement(hoverOverPlatforme).moveToElement(driver.findElement(By.cssSelector("li>a[href='https://intranet.unitbv.ro/']"))).click().build().perform();
    }

    public void switchTabFocus()
    {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public WebElement getWaitForCookie() {
        return waitForCookie;
    }

    public void setWaitForCookie(WebElement waitForCookie) {
        this.waitForCookie = waitForCookie;
    }

    public WebElement getWaitForPlatformeElement() {
        return waitForPlatformeElement;
    }

    public void setWaitForPlatformeElement(WebElement waitForPlatformeElement) {
        this.waitForPlatformeElement = waitForPlatformeElement;
    }
}
