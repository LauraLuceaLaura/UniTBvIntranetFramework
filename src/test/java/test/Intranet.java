package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Intranet {

    public WebDriver driver;

    @Test
    public void intranet()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://intranet.unitbv.ro/autentificare?returnurl=%2f");
        driver.manage().window().maximize();

        WebElement fillEmailField = driver.findElement(By.cssSelector("input[id='dnn_ctr2093_Login_Login_LDAP UNITBV_lgAGSISPortalLogin_UserName']"));
        String emailValue = "laura.lucea@student.unitbv.ro";
        fillEmailField.sendKeys(emailValue);

        WebElement fillPasswordField = driver.findElement(By.cssSelector("input[id='dnn_ctr2093_Login_Login_LDAP UNITBV_lgAGSISPortalLogin_Password']"));
        String passwordValue = "TestareAutomata1";
        fillPasswordField.sendKeys(passwordValue);

        WebElement clickIntrainCont = driver.findElement(By.cssSelector("a[id='dnn_ctr2093_Login_Login_LDAP UNITBV_lgAGSISPortalLogin_LoginButton']"));
        clickIntrainCont.click();

        WebElement clickServiciiIT = driver.findElement(By.linkText("https://intranet.unitbv.ro/Servicii-IT"));
        clickServiciiIT.click();

    }

}
