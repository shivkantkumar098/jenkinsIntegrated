package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsInSelenium {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }
    @Test
    public void waitsInSelenium(){
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2));
        //explicit wait
        WebElement welcomeNote=driver.findElement(By.xpath("//h1[.=\"Welcome to the-internet\"]"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[.=\"Welcome to the-internet\"]")));
       // Fluent Wait

        FluentWait fluentWait=new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[.=\"Welcome to the-internet\"]")));


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
