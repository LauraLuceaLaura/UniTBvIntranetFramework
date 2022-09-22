package shareData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ShareData {

    public WebDriver driver;
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
        driver.get("https://www.unitbv.ro/");
        driver.manage().window().maximize();
    }


    public void quitDriver(){
        driver.quit();
    }
}
