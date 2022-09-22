package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IntranetPage extends BasePage {

    public IntranetPage(WebDriver driver) {
        super(driver);
    }

   @FindBy(css = "a[href='https://intranet.unitbv.ro/Servicii-IT']")
   private WebElement  waitForSetviciiITElement;

    @FindBy(css = "a[href=\"/Secretariat/Studenti/Grupe-studenti\"]")
    private WebElement waitForGrupeStudentiElement ;

    @FindBy(css = "div>select>option[value='41']")
    private WebElement selectAnUniversitar;

    @FindBy(css = "td>select>option[value='13']")
    private WebElement selectFacultatea;

    @FindBy(css = "td>select>option[value='13']")
    private WebElement selectCicluInvatamant ;

    @FindBy(css = "td>select>option[value='10998']")
    private WebElement selectFormaInvatamant ;

    @FindBy(css = "td>select>option[value='23527']")
    private WebElement selectDomeniu ;

    @FindBy(css = "td>select>option[value='10908']")
    private WebElement selectProgramStudii ;

    @FindBy(id = "dnn_ctr1884_GrupeStudenti_FDSG1_ddlAnStudiu")
    private List<WebElement> selectAnStudii ;

    @FindBy(css = "td>select>option[value='24047']")
    private WebElement selectGrupa ;

    @FindBy(id = "dnn_ctr1884_GrupeStudenti_lnkAfisareRaport")
    private WebElement clickAfisareRaport ;

    @FindBy(css = "td>div[class='A93ce46954f814d1eb54c49d791f9036c48']")
    private List<WebElement> verifyMyName ;

    @FindBy(id = "dnn_ctr1884_GrupeStudenti_ReportViewer1_ctl05_ctl04_ctl00_ButtonImgDown")
    private WebElement saveOption ;

    public void generateStatement()
    {
        accessServiciiITPlatfom();
        verifyServiciiITTitle("Servicii IT");
        accessGrupeStudentiPlatfom();
        verifyGrupeStudentiTitle("Grupe studenti");
        getSelectAnUniversitar().click();
        getSelectFacultatea().click();
        getSelectCicluInvatamant().click();
        getSelectFormaInvatamant().click();
        getSelectDomeniu().click();
        getSelectProgramStudii().click();
        selectAnStudiiElement();
        getSelectGrupa().click();
        getClickAfisareRaport().click();
        verifyMyNameInStatement("laura.lucea@student.unitbv.ro");
        downloadOptions("PDF");
    }

    public void accessServiciiITPlatfom()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getWaitForSetviciiITElement()));
        WebElement clickServiciiIT = driver.findElement((By) getWaitForSetviciiITElement());
        clickServiciiIT.click();
    }

    public void verifyServiciiITTitle(String expectedTitleServiciiIT)
    {
        String actualTitleServiciiIT = driver.getTitle();
        Assert.assertEquals(expectedTitleServiciiIT, actualTitleServiciiIT);
    }

    public void accessGrupeStudentiPlatfom()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getWaitForGrupeStudentiElement()));
        WebElement clickGrupeStudenti = driver.findElement((By) getWaitForGrupeStudentiElement());
        clickGrupeStudenti.click();
    }

    public void verifyGrupeStudentiTitle(String expectedTitleGrupeStudenti)
    {
        String actualTitleGrupeStudenti = driver.getTitle();
        Assert.assertEquals(expectedTitleGrupeStudenti, actualTitleGrupeStudenti);
    }

    public void selectAnStudiiElement()
    {
        for (Integer i = 0; i < getSelectAnStudii().size(); i++) {
            if (getSelectAnStudii().get(i).getText().equals("II")) {
                getSelectAnStudii().get(i).click();
            }
        }
    }

    public void verifyMyNameInStatement(String myEmail)
    {
        Integer ok = 0;
        for (Integer i = 0; i < getVerifyMyName().size(); i++) {
            if (getVerifyMyName().get(i).getText().equals(myEmail)) {
                ok = 1;
            }
            System.out.println(ok);
        }
    }

    public void downloadOptions(String fileFormat) {
        getSaveOption().click();

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

    public WebElement getWaitForSetviciiITElement() {
        return waitForSetviciiITElement;
    }

    public WebElement getWaitForGrupeStudentiElement() {
        return waitForGrupeStudentiElement;
    }

    public WebElement getSelectAnUniversitar() {
        return selectAnUniversitar;
    }

    public WebElement getSelectFacultatea() {
        return selectFacultatea;
    }

    public WebElement getSelectCicluInvatamant() {
        return selectCicluInvatamant;
    }

    public WebElement getSelectFormaInvatamant() {
        return selectFormaInvatamant;
    }

    public WebElement getSelectDomeniu() {
        return selectDomeniu;
    }

    public WebElement getSelectProgramStudii() {
        return selectProgramStudii;
    }

    public List<WebElement> getSelectAnStudii() {
        return selectAnStudii;
    }

    public WebElement getSelectGrupa() {
        return selectGrupa;
    }

    public WebElement getClickAfisareRaport() {
        return clickAfisareRaport;
    }

    public List<WebElement> getVerifyMyName() {
        return verifyMyName;
    }

    public WebElement getSaveOption() {
        return saveOption;
    }
}
