package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[id='dnn_ctr2093_Login_Login_LDAP UNITBV_lgAGSISPortalLogin_UserName']")
    private WebElement fillEmailField;

    @FindBy(css = "input[id='dnn_ctr2093_Login_Login_LDAP UNITBV_lgAGSISPortalLogin_Password']")
    private WebElement fillPasswordField;

    @FindBy(css = "a[id='dnn_ctr2093_Login_Login_LDAP UNITBV_lgAGSISPortalLogin_LoginButton']")
    private WebElement clickIntraInCont;

    public void login()
    {
        verifyIntranetPageTitleMethod();
        fillEmailFieldMethod();
        fillPasswordFieldMethod();
        accessIntranetAccountMethod();
    }

    public void verifyIntranetPageTitleMethod()
    {
        String actualTitleIntranet = driver.getTitle();
        String expectedTitleIntranet = "Intranet UniTBv";
        Assert.assertEquals(expectedTitleIntranet, actualTitleIntranet);
    }

    public void fillEmailFieldMethod() {

        String emailValue = "laura.lucea@student.unitbv.ro";
        getFillEmailField().sendKeys(emailValue);
    }

    public void fillPasswordFieldMethod()
    {

        String passwordValue = "TestareAutomata1";
        getFillPasswordField().sendKeys(passwordValue);
    }

    public void accessIntranetAccountMethod()
    {
       getClickIntraInCont().click();
    }

    public WebElement getFillEmailField() {
        return fillEmailField;
    }

    public void setFillEmailField(WebElement fillEmailField) {
        this.fillEmailField = fillEmailField;
    }

    public WebElement getFillPasswordField() {
        return fillPasswordField;
    }

    public void setFillPasswordField(WebElement fillPasswordField) {
        this.fillPasswordField = fillPasswordField;
    }

    public WebElement getClickIntraInCont() {
        return clickIntraInCont;
    }

    public void setClickIntraInCont(WebElement clickIntraInCont) {
        this.clickIntraInCont = clickIntraInCont;
    }
}
