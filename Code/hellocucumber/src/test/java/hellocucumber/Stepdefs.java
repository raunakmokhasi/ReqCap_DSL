package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Stepdefs {

    WebDriver driver;

    @Given("Open the Chrome Browser and launch the application")
    public void open_the_Chrome_Browser_and_launch_the_application() {

        System.setProperty("webdriver.chrome.driver", "C://Code//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/v4");

    }

    @When("Enter the Username and Password")
    public void enter_the_Username_and_Password() {
        driver.findElement(By.name("uid")).sendKeys("username12");
        driver.findElement(By.name("password")).sendKeys("password12");
    }

    @When("Reset the credential")
    public void reset_the_credential() {
        driver.findElement(By.name("btnReset")).click();
    }

    @Then("Username and Password is empty")
    public void username_and_Password_is_empty() {
        String username = driver.findElement(By.name("uid")).getText();
        String password = driver.findElement(By.name("password")).getText();
        assertEquals(username,"");
        assertEquals(password,"");

    }

}
