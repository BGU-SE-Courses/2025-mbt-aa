package hellocucumber;

import java.time.Duration;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.parallel.Execution;
import org.openqa.selenium.*;
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

    // Entry point for the test, initialize driver and moodle home page
    @Given("Student is on Home page")
    @Given("Teacher is on Home page")
    public void userIsOnHomePage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yossi\\OneDrive - post.bgu.ac.il\\selfStudy\\שולחן העבודה\\qa\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);//new SafariDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get(MOODLE_URL_2);
    }
    // log in the user to moodle
    @And("Student is logged in with {string} and {string}")
    @And("Teacher is logged in with {string} and {string}")
    public void userIsLoggedIn(String username, String password){
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
    // Entering the courses page on moodle
    @And("Student is on courses page")
    @And("Teacher is on courses page")
    public void userIsOnCoursesPage(){
        try {
            Thread.sleep(defaultSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]/a")).click();
    }
    // Enters a specific course to work on
    @And("Student has a course")
    @And("Teacher has a course")
    public void userHasACourse(){
        try {
            Thread.sleep(defaultSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div/div[1]/div/div/a/span[3]/span[2]")).click();
    }
    // Entering a specific forum inside the course
    @And("Course has a forum discussion")
    public void CourseHasAForum(){
        try {
            Thread.sleep(defaultSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[3]/div/section/div/div/div/ul/li[3]/div/div[2]/ul/li/div/div[2]/div[2]/div/div/a")).click();
    }

    // subscribe the student to the discussion
    @When("Student subscribes to a forum discussion")
    public void studentSubscribesToADiscussion() {
        try {
            Thread.sleep(defaultSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[3]/div/table/tbody/tr/td[5]/div")).click();
    }

    // end of student scenario, make sure the student did subscribe to the discussion
    @Then("The student successfully subscribed to the discussion")
    public void successfulSubscribe() {
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[3]/div/table/tbody/tr/td[5]/div"));
        try {
            Thread.sleep(defaultSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // teacher entering specific discussion inside the forum
    @And("Teacher in specific forum discussion page")
    public void TeacherEnteringDiscussion() {
        try {
            Thread.sleep(defaultSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/div[2]/div[3]/div/table/tbody/tr/th/div/div[1]/a")).click();
    }

    // teacher deletes the discussion
    @When("Teacher deletes a forum discussion")
    public void TeacherDeletesForumDiscussion() {
        try {
            Thread.sleep(defaultSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[3]/div/section/div[2]/div/article/div[1]/div/div/div[2]/div[2]/div/a[3]")).click();
        try {
            Thread.sleep(defaultSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[3]/div/section/div[2]/div/div/div[3]/div/div[2]/form/button")).click();
    }

    // end of teacher scenario, makes sure the discussion was successfully deleted
    @Then("The Teacher successfully deletes the discussion")
    public void TeacherScenarioPasses() throws Exception {

        try {
            Thread.sleep(defaultSleepTime);
            driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[3]/div/section/div[2]/div/article/div[1]/div/div/div[2]/div[2]/div/a[3]"));
            throw new Exception("deleted element was found");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (NoSuchElementException e){}


    }

}
