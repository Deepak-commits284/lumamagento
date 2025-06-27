package SeleniumAutomation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccountCreationTest {

    public static void main(String[] args) {
        // Launch the Browser
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to the URL
        String url = "https://magento.softwaretestingboard.com/";
        driver.navigate().to(url);
        driver.manage().window().maximize();

        // Scroll the page down
        scrollPage(driver, 500);

        // Call the functions for various operations
        createValidAccount(driver);
        signOutAccount(driver);
        signInAccount(driver);
        changePassword(driver);

        // Close the driver after the test completes
        driver.quit();
    }

    // Scroll the page by a specified number of pixels
    private static void scrollPage(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + pixels + ")");
    }

    // Create a valid account and verify redirection
    public static void createValidAccount(WebDriver driver) {
        driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/create/");
        ElementLocator.createAccount(driver).click();
        ElementLocator.firstName(driver).sendKeys("demo");
        ElementLocator.lastName(driver).sendKeys("user");
        ElementLocator.email(driver).sendKeys("demouser@27625gmail.com");
        ElementLocator.password(driver).sendKeys("du!@#27625");
        ElementLocator.confirmPassword(driver).sendKeys("du!@#27625");
        ElementLocator.saveAccount(driver).click();

        // Verify if the user is redirected correctly
        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.equals(expectedUrl)) {
            System.out.println("❌ TC_ID_AC_01 - CreateAccount_ValidCredentials: FAILED - User is still on the registration page.");
        } else {
            System.out.println("✅ TC_ID_AC_01 - CreateAccount_ValidCredentials: PASSED - User Account Created Successfully.");
        }
    }

    // Sign out from the account
    public static void signOutAccount(WebDriver driver) {
        ElementLocator.signOutMenu(driver).click();
        ElementLocator.signOutList(driver).click();
        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("❌ TC_ID_AC_02 - SignOut_Failed: FAILED - User is still on the account page.");
        } else {
            System.out.println("✅ TC_ID_AC_02 - SignOut_Success: PASSED - User was redirected to the account page.");
        }
    }

    // Sign in to the account
    public static void signInAccount(WebDriver driver) {
        ElementLocator.signInPage(driver).click();
        ElementLocator.emailSignIn(driver).sendKeys("demouser@27625gmail.com");
        ElementLocator.passwordSignIn(driver).sendKeys("du!@#27625");
        ElementLocator.signInButton(driver).click();

        // Verify if the user is redirected correctly
        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("❌ TC_ID_AC_03 - SignIn_ValidCredentials: FAILED - Failed to sign in.");
        } else {
            System.out.println("✅ TC_ID_AC_03 - SignIn_ValidCredentials: PASSED - User successfully signed in.");
        }
    }

    // Change the account password
    public static void changePassword(WebDriver driver) {
        scrollPage(driver, 800);
        ElementLocator.changePassword(driver).click();
        driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/edit/changepass/1/");
        scrollPage(driver, 600);

        ElementLocator.currentPassword(driver).sendKeys("du!@#27625");
        ElementLocator.password(driver).sendKeys("demo!@#27625");
        ElementLocator.confirmPassword(driver).sendKeys("demo!@#1234");
        ElementLocator.saveAccount(driver).click();

        // Verify if the password change was successful
        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/edit/changepass/1/";
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("❌ TC_ID_AC_04 - ChangePassword_Failure: FAILED - Password change failed.");
        } else {
            System.out.println("✅ TC_ID_AC_04 - ChangePassword_Success: PASSED - Password changed successfully.");
        }
    }
}
