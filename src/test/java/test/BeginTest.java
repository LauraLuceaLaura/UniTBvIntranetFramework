package test;

import org.junit.Assert;
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

        By clickCookie = By.xpath("//div[@class='cookie-consent-footer-content']//button[contains(@class,'cookie-consent')]");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(clickCookie));
        WebElement clickOk = driver.findElement(clickCookie);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", clickOk);

        String actualText = driver.getTitle();
        String expectedText = "UniTBv";
        Assert.assertEquals(expectedText, actualText);


        Thread.sleep(5);
        By waitPlatforme = By.cssSelector("ul>li[id='iceMenu_773']");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(waitPlatforme));
        WebElement hoverOverPlatforme = driver.findElement(waitPlatforme);
        Actions builder = new Actions(driver);
        Thread.sleep(1000);
        builder.moveToElement(hoverOverPlatforme).perform();
//        WebElement clickIntranet = driver.findElement(By.cssSelector("li>a[href='https://intranet.unitbv.ro/']"));
        Actions action = new Actions(driver);
        Thread.sleep(1000);
        action.moveToElement(hoverOverPlatforme).moveToElement(driver.findElement(By.cssSelector("li>a[href='https://intranet.unitbv.ro/']"))).click().build().perform();


//        List<WebElement> platformeOptions = driver.findElements(By.cssSelector("ul[class='icesubMenu icemodules sub_level_1 visible']"));
//        for(Integer i=0; i<platformeOptions.size();i++)
//        {
//            if(platformeOptions.get(i).getText().equals("Intranet"))
//            {
//                platformeOptions.get(i).click();
//            }
//        }

//        WebElement clickOnIntranet = driver.findElement(By.cssSelector("li>div>ul>li>div>div>div>ul>li>a>img[alt='Intranet']"));
//        Actions action = new Actions(driver);
//        action.moveToElement(hoverOverPlatforme).moveToElement(clickOnIntranet).click();

    }
}
