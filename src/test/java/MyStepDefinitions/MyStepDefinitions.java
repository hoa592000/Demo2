package MyStepDefinitions;
import PageObjects.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@RunWith(Cucumber.class)
public class MyStepDefinitions {
    WebDriver driver;
    Login login;
    @Before
    public void StartSenario(){
        System.setProperty("webdriver.gecko.driver", "D:\\AutoTest\\geckodriver-v0.30.0-win64(1)\\geckodriver.exe");
        driver = new FirefoxDriver();
        login = new Login(driver);
    }
    @Given("^User go to page$")
    public void user_go_to_page() throws Throwable {
        this.driver.get("https://rahulshettyacademy.com/locatorspractice/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("^User login into application with \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_something_and_password_something(String strArg1, String strArg2) throws Throwable {
        /* driver.findElement(By.id("inputUsername")).sendKeys(strArg1);
        driver.findElement(By.name("inputPassword")).sendKeys(strArg2);
        driver.findElement(By.cssSelector("button[type='submit']")).click(); */
        login.txtUsername.sendKeys(strArg1);
        login.txtPassword.sendKeys(strArg2);
        login.btnLogin.click();

    }

    @Then("Home page is populated with {string}")
    public void home_page_is_populated_with_something(String strArg1) throws Throwable  {
        /* System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("p.error")).getText(), strArg1); */
        Assert.assertEquals(strArg1, login.linkSpec.getText());
    }

    @And("^Close app$")
    public void close_app() throws Throwable {
        driver.close();
    }

}