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
import java.util.ArrayList;
import java.util.List;

//asta merge

public class GenerateGrupeStudentiStatement {

    public WebDriver driver;

    @Test
    public void testGenerateGrupeStudentiStatement() throws InterruptedException
    {
          setDriver();
          acceptCookie();
          verifyUniTBvPageTitle();
          accessIntranetPlatform();
          switchTabFocus();
          verifyIntranetPageTitle();
          fillEmailField();
          fillPasswordField();
          accessIntranetAccount();
          accessServiciiITPlatfom();
          verifyServiciiITTitle();
          accessGrupeStudentiPlatfom();
          verifyGrupeStudentiTitle();
          selectAnUniversitarElement();
          selectFacultateaElement();
          selectCicluInvatamantElement();
          selectFormaInvatamantElement();
          selectDomeniulElement();
          selectProgramStudiiElement();
          selectAnStudiiElement();
          selectGrupaElement();
          generateStatement();
          verifyMyNameInStatement();
          downloadOptions("Word");
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

    public void verifyIntranetPageTitle()
    {
        String actualTitleIntranet = driver.getTitle();
        String expectedTitleIntranet = "Intranet UniTBv";
        Assert.assertEquals(expectedTitleIntranet, actualTitleIntranet);
    }

    public void fillEmailField() throws InterruptedException {
//        By waitEmailField = By.cssSelector("input[id='dnn_ctr2093_Login_Login_LDAP UNITBV_lgAGSISPortalLogin_UserName']");
//        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(waitEmailField));
//        Thread.sleep(1000);
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

    public void accessServiciiITPlatfom()
    {
        By waitSetviciiIT = By.cssSelector("a[href='https://intranet.unitbv.ro/Servicii-IT']");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(waitSetviciiIT));
        WebElement clickServiciiIT = driver.findElement(waitSetviciiIT);
        clickServiciiIT.click();
    }

    public void verifyServiciiITTitle()
    {
        String actualTitleServiciiIT = driver.getTitle();
        String expectedTitleServiciiIT = "Servicii IT";
        Assert.assertEquals(expectedTitleServiciiIT, actualTitleServiciiIT);
    }

    public void accessGrupeStudentiPlatfom()
    {
        By waitGrupeStudenti = By.cssSelector("a[href=\"/Secretariat/Studenti/Grupe-studenti\"]");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(waitGrupeStudenti));
        WebElement clickGrupeStudenti = driver.findElement(waitGrupeStudenti);
        clickGrupeStudenti.click();
    }

    public void verifyGrupeStudentiTitle()
    {
        String actualTitleGrupeStudenti = driver.getTitle();
        String expectedTitleGrupeStudenti = "Grupe studenti";
        Assert.assertEquals(expectedTitleGrupeStudenti, actualTitleGrupeStudenti);
    }

    public void selectAnUniversitarElement()
    {
        WebElement selectAnUniversitar = driver.findElement(By.cssSelector("div>select>option[value='41']"));
        selectAnUniversitar.click();
    }

    public void selectFacultateaElement()
    {
        WebElement selectFacultatea = driver.findElement(By.cssSelector("td>select>option[value='13']"));
        selectFacultatea.click();
    }

    public void selectCicluInvatamantElement()
    {
        WebElement selectCicluInvatamant = driver.findElement(By.cssSelector("td>select>option[value='972']"));
        selectCicluInvatamant.click();
    }

    public void selectFormaInvatamantElement()
    {
        WebElement selectFormaInvatamant = driver.findElement(By.cssSelector("td>select>option[value='10998']"));
        selectFormaInvatamant.click();
    }

    public void selectDomeniulElement()
    {
        WebElement selectDomeniu = driver.findElement(By.cssSelector("td>select>option[value='23527']"));
        selectDomeniu.click();
    }

    public void selectProgramStudiiElement()
    {
        WebElement selectProgramStudii = driver.findElement(By.cssSelector("td>select>option[value='10908']"));
        selectProgramStudii.click();
    }

    public void selectAnStudiiElement()
    {
        List<WebElement> selectAnStudii = driver.findElements(By.id("dnn_ctr1884_GrupeStudenti_FDSG1_ddlAnStudiu"));
        for (Integer i = 0; i < selectAnStudii.size(); i++) {
            if (selectAnStudii.get(i).getText().equals("II")) {
                selectAnStudii.get(i).click();
            }
        }
    }

    public void selectGrupaElement()
    {
        WebElement selectGrupa = driver.findElement(By.cssSelector("td>select>option[value='24047']"));
        selectGrupa.click();
    }

    public void generateStatement()
    {
        WebElement clickAfisareRaport = driver.findElement(By.id("dnn_ctr1884_GrupeStudenti_lnkAfisareRaport"));
        clickAfisareRaport.click();
    }

    public void verifyMyNameInStatement()
    {
        List<WebElement> verifyMyName = driver.findElements(By.cssSelector("td>div[class='A93ce46954f814d1eb54c49d791f9036c48']"));
        Integer ok = 0;
        for (Integer i = 0; i < verifyMyName.size(); i++) {
            if (verifyMyName.get(i).getText().equals("laura.lucea@student.unitbv.ro")) {
                ok = 1;
            }
            System.out.println(ok);
        }
    }

    public void downloadOptions(String fileFormat) {
        WebElement saveElement = driver.findElement(By.id("dnn_ctr1884_GrupeStudenti_ReportViewer1_ctl05_ctl04_ctl00_ButtonImgDown"));
        saveElement.click();

        switch (fileFormat) {
            case "Excel":
                WebElement saveAsExcel = driver.findElement(By.cssSelector("a[title='Excel']"));
                saveAsExcel.click();
                break;
            case "PDF":
                WebElement saveAsPDF = driver.findElement(By.cssSelector("a[title='PDF']"));
                saveAsPDF.click();
                break;
            case "Word":
                WebElement saveAsWord = driver.findElement(By.cssSelector("a[title='Word']"));
                saveAsWord.click();
                break;
        }

    }
}
