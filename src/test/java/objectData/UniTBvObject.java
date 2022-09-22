package objectData;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import page.UniTBvPage;
import shareData.ShareData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UniTBvObject extends BasePage{

   //public WebDriver driver;

    public UniTBvObject(WebDriver driver) {
        super(driver);
    }

    public void prepareAccessToIntranetPage() throws InterruptedException {
        setDriver();
        acceptCookie();
        verifyUniTBvPageTitle();
        accessIntranetPlatform();
        switchTabFocus();
        quitDriver();
    }

    public void setDriver()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.unitbv.ro/");
        driver.manage().window().maximize();
    }

    public void acceptCookie()
    {
        By clickCookie = By.xpath("//div[@class='cookie-consent-footer-content']//button[contains(@class,'cookie-consent')]");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(clickCookie));
        WebElement clickOk = driver.findElement(clickCookie);
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
        By waitPlatforme = By.cssSelector("ul>li[id='iceMenu_773']");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(waitPlatforme));
        WebElement hoverOverPlatforme = driver.findElement(waitPlatforme);
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

    public void quitDriver(){
        driver.quit();
    }

}
