package shareData;

import PropertiesFile.PropertyUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

public class Hooks extends  ShareData{

    public HashMap<String, String> testData;


    @BeforeMethod
    public void prepareEnviorment()
    {
        prepareDriver();
        String className = this.getClass().getSimpleName();
        PropertyUtility propertyFile = new PropertyUtility(className);
        testData = propertyFile.getAllKeyValue();
    }

    @AfterMethod
    public void clearEnviorment()
    {
        quitDriver();
    }
}
