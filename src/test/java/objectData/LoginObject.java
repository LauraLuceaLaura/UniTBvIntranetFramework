package objectData;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.LoginPage;

import java.time.Duration;

public class LoginObject extends UniTBvObject{

    public LoginObject(WebDriver driver) {
        super(driver);

    }

    public void loginToIntranetPageProccess() throws InterruptedException {
         prepareDriver();
        verifyIntranetPageTitle();
        fillEmailField();
        fillPasswordField();
        accessIntranetAccount();
    }

    public void prepareDriver(){

        String cicd = System.getProperty("cicd");
        ChromeOptions options = new ChromeOptions();
        if(Boolean.parseBoolean(cicd))
        {
            options.addArguments("--headless");
        }
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.get("https://intranet.unitbv.ro/autentificare?returnurl=%2f");
        driver.manage().window().maximize();
    }


    public void verifyIntranetPageTitle()
    {
        String actualTitleIntranet = driver.getTitle();
        String expectedTitleIntranet = "Intranet UniTBv";
        Assert.assertEquals(expectedTitleIntranet, actualTitleIntranet);
    }

    public void fillEmailField() throws InterruptedException
    {
        By waitEmailField = By.cssSelector("input[id='dnn_ctr2093_Login_Login_LDAP UNITBV_lgAGSISPortalLogin_UserName']");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(waitEmailField));
        Thread.sleep(1000);
        WebElement fillEmailField = driver.findElement(By.cssSelector("input[id='dnn_ctr2093_Login_Login_LDAP UNITBV_lgAGSISPortalLogin_UserName']"));
        String emailValue = "laura.lucea@student.unitbv.ro";
        fillEmailField.sendKeys(emailValue);
    }

    public void fillPasswordField()
    {
        WebElement fillPasswordField = driver.findElement(By.cssSelector("input[id='dnn_ctr2093_Login_Login_LDAP UNITBV_lgAGSISPortalLogin_Password']"));
        String passwordValue = "TestareAutomata1";
        fillPasswordField.sendKeys(passwordValue);
    }

    public void accessIntranetAccount()
    {
        WebElement clickIntraInCont = driver.findElement(By.cssSelector("a[id='dnn_ctr2093_Login_Login_LDAP UNITBV_lgAGSISPortalLogin_LoginButton']"));
        clickIntraInCont.click();
    }

}
