package test;

import objectData.IntranetObject;
import objectData.LoginObject;
import objectData.UniTBvObject;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import shareData.Hooks;

//asta aproape merge

public class GrupeStudenti  extends Hooks{

    public WebDriver driver;

    @Test
    public void testGenerateGrupestudentiStatement() throws InterruptedException {
        UniTBvObject uniTBvObject = new UniTBvObject(driver);
        LoginObject loginObject = new LoginObject(driver);
        IntranetObject intranetObject = new IntranetObject(driver);

        uniTBvObject.prepareAccessToIntranetPage();
        loginObject.loginToIntranetPageProccess();
        intranetObject.generateStudentsStatementProccess();
    }

    public void setDriver()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.unitbv.ro/");
        driver.manage().window().maximize();
    }

}
