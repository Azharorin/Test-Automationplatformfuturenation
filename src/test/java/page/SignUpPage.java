package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignUpPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Sign up']")
    WebElement signupBtn;
    @FindBy(xpath = "//input[@id=':r0:']")
    WebElement emailTxt;
    @FindBy(xpath = "//input[@id=':r1:']")
    WebElement passTxt;
    @FindBy(xpath = "//input[@id=':r2:']")
    WebElement PassrepeatTxt;
    // @FindBy(xpath = "//button[text()='Get Started']")
    @FindBy(xpath = "//button[@type='submit']")
    WebElement getstartedBtn;
    @FindBy(xpath = "//h1[text()='Verify your email']")
    public
    WebElement verifyTxt;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void doSignup(String username, String password, String passwordrep) throws InterruptedException {
        Actions actions = new Actions(driver);
        //  actions.moveToElement(signupBtn).perform();
        actions.moveToElement(signupBtn).click().perform();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        emailTxt.sendKeys(username);
        passTxt.sendKeys(password);
        PassrepeatTxt.sendKeys(passwordrep);



        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        wait.until(ExpectedConditions.elementToBeClickable(getstartedBtn));



        /*
        both code will be working fine for particular scrolling it will works
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center', behavior: 'smooth'});", getstartedBtn);
*/





        getstartedBtn.click();
        // Assert.assertTrue(verifyTxt.isDisplayed());







    }


}
