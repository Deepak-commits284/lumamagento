package SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementLocator {

    //--------- CREATE ACCOUNT ------------------    
    // Personal Information
    public static WebElement createAccount(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a"));
    }

    public static WebElement firstName(WebDriver driver) {
        return driver.findElement(By.id("firstname"));
    }

    public static WebElement lastName(WebDriver driver) {
        return driver.findElement(By.id("lastname"));
    }

    // Sign-In Information
    public static WebElement email(WebDriver driver) {
        return driver.findElement(By.id("email_address"));
    }

    public static WebElement password(WebDriver driver) {
        return driver.findElement(By.id("password"));
    }

    public static WebElement confirmPassword(WebDriver driver) {
        return driver.findElement(By.id("password-confirmation"));
    }

    public static WebElement saveAccount(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));
    }

    //--------- SIGN OUT ACCOUNT ------------------
    public static WebElement signOutMenu(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button"));
    }    
    
    public static WebElement signOutList(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a"));
    }

    //--------- SIGN IN ACCOUNT ------------------
    public static WebElement signInPage(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
    }

    public static WebElement emailSignIn(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"email\"]"));
    }

    public static WebElement passwordSignIn(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"pass\"]"));
    }

    public static WebElement signInButton(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"send2\"]/span"));
    }

    //--------- CHANGE PASSWORD ------------------
    public static WebElement changePassword(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[2]/a[2]"));
    }

    public static WebElement currentPassword(WebDriver driver) {
        return driver.findElement(By.id("current-password"));
    }
}
