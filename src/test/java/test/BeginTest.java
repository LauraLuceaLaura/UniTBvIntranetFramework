package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BeginTest {

    public WebDriver driver;

    @Test
    public void aTry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.unitbv.ro/");
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();

        By clickCookie = By.xpath("//div[@class='cookie-consent-footer-content']//button[contains(@class,'cookie-consent')]");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(clickCookie));
        WebElement clickOk = driver.findElement(clickCookie);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", clickOk);

        Actions action = new Actions(driver);
        WebElement hoverOverPlatforme = driver.findElement(By.id("iceMenu_773"));
        WebElement clickOnIntranet = driver.findElement(By.cssSelector("li>div>ul>li>div>div>div>ul>li>a>img[alt='Intranet']"));
        action.moveToElement(hoverOverPlatforme).moveToElement(clickOnIntranet).click(); //.build().perform();




    }
}
