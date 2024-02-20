package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class Setup {

    public WebDriver driver;


    @BeforeTest
    public void setup(){

         driver= new FirefoxDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://platform.futurenation.gov.bd/");


    }

    @AfterMethod

    public void screenShot(ITestResult result){
        if (ITestResult.FAILURE== result.getStatus()){
            try{
                Utils.takeScreenshots(driver);
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }

    @AfterTest
    public void quitDriver(){
      //  driver.quit();

    }

}
