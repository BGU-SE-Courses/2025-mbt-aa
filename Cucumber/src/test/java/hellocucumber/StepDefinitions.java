package hellocucumber;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitions {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private final int defaultSleepTime = 2000;
    private final String MOODLE_URL = "http://localhost:8888/moodle405/";
    private final String MOODLE_URL_2 = "http://localhost/";

    // $$*TODO* explain what this step does$$
    @Given("Student is on Home page")
    public void studentIsOnHomePage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yossi\\OneDrive - post.bgu.ac.il\\selfStudy\\שולחן העבודה\\qa\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);//new SafariDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get(MOODLE_URL_2);
    }

    @And("Student is logged in with {string} and {string}")
    public void studentIsLoggedIn(String username, String password){
        WebElement loginElement = driver.findElement(By.xpath("//*[@id=\"usernavigation\"]/div/div/span/a"));
        loginElement.click();
        try {
            Thread.sleep(defaultSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/form[1]/div[1]/input[1]"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[1]/input[1]"))).sendKeys(password);
        driver.findElement(By.xpath("//form[1]/div[3]/button[1]")).click();
    }
    @And("Student is on courses page")
    public void studentIsOnCoursesPage(){
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        WebElement courseElement = driver.findElement(By.xpath("//div[1]/div[1]/h3[1]/a[1]"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", courseElement);
        driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]/a")).click();

    }

    @And("Student has a course")
    public void studentHasACourse(){
        try {
            Thread.sleep(defaultSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div/div[1]/div/div/a/span[3]/span[2]")).click();
    }

    @And("Course has a forum discussion")
    public void CourseHasAForum(){
        try {
            Thread.sleep(defaultSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[3]/div/section/div/div/div/ul/li[3]/div/div[2]/ul/li/div/div[2]/div[2]/div/div/a")).click();
    }

    // $$*TODO* explain what this step does$$
    @When("Student subscribes to a forum discussion")
    public void studentSubscribesToADiscussion() {
        try {
            Thread.sleep(defaultSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[3]/div/table/tbody/tr/td[5]/div")).click();
    }

    // $$*TODO* explain what this step does$$
    @Then("The student successfully subscribed to the discussion")
    public void theScenarioPasses() {
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[3]/div/table/tbody/tr/td[5]/div"));
        try {
            Thread.sleep(defaultSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
