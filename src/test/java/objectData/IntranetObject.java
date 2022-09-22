package objectData;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.IntranetPage;
import shareData.ShareData;

import java.time.Duration;
import java.util.List;

public class IntranetObject {

    public WebDriver driver;

    public IntranetObject(WebDriver driver) {
        this.driver = driver;
    }

    public void generateStudentsStatementProccess()
    {
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
        downloadOptions("PDF");
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
