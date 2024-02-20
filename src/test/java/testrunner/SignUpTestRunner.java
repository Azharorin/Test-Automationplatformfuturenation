package testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SignUpPage;
import setup.Setup;

public class SignUpTestRunner extends Setup {

    @Test(priority = 1,description = "user sign up")

    public void doSignUp() throws InterruptedException {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.doSignup("azharalamorinsss@gmail.com", "Abc@1234", "Abc@1234");
        //signUpPage.getstartedBtn.click();
        Assert.assertTrue(signUpPage.verifyTxt.isDisplayed());
        ;


    }

}
