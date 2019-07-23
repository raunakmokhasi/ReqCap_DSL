package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;


public class Stepdefs {

    WebDriver driver;

    @Given("Open the Chrome Browser and launch the Login page")
    public void open_the_Chrome_Browser_and_launch_the_Login_page() {
        System.setProperty("webdriver.chrome.driver", "C://Code//chromedriver.exe");

        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type", "--start-maximized", "--disable-web-security", "--allow-running-insecure-content");
        //capabilities.setCapability("chrome.binary","C://Code//chromedriver.exe");
        //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);
        driver.get("http://localhost/dslInternshipWebsite/index.html");
    }

    @When("Enter Raunak as Username and Mokhasi as Password")
    public void enter_Raunak_as_Username_and_Mokhasi_as_Password() {
        driver.findElement(By.name("email")).sendKeys("raunak");
        driver.findElement(By.name("pwd")).sendKeys("mokhasi");
    }

    @Then("Show invalid login alert")
    public void show_invalid_login_alert() {
    }

    @Given("Open the Chrome Browser and launch the Quotes page")
    public void open_the_Chrome_Browser_and_launch_the_Quotes_page() {
        System.setProperty("webdriver.chrome.driver", "C://Code//chromedriver.exe");

        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type", "--start-maximized", "--disable-web-security", "--allow-running-insecure-content");
        //capabilities.setCapability("chrome.binary","C://Code//chromedriver.exe");
        //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);
        driver.get("http://localhost/dslInternshipWebsite/quotes.html");
    }

    @When("Click the Inspire button")
    public void click_the_Inspire_button() {
        driver.findElement(By.name("btnGetInspireQuote")).click();
    }

    @When("Click the Sports button")
    public void click_the_Sports_button() {
        driver.findElement(By.name("btnGetSportsQuote")).click();
    }

    @When("Click the login button")
    public void click_the_login_button() {
        driver.findElement(By.name("btnLogin")).click();
    }

    @When("Click Get Quote button")
    public void click_Get_Quote_button() {
        driver.findElement(By.name("btnGetQuote")).click();
    }

    @Then("Show quote in alert")
    public void show_quote_in_alert() {
    }

    @Then("Log the user in and load Quotes page")
    public void log_the_user_in_and_load_Quotes_page() {
        List<WebElement> list = driver.findElements(By.name("btnGetInspireQuote"));
        Assert.assertTrue("Text not found!", list.size() > 0);
    }
}