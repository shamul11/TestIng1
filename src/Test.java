import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Test {


    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\uh12118\\Documents\\browser\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.get("https://www.bcom-050.tbe.zeus.fds.com/");
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(10, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);
        driver.findElement(By.linkText("MY ACCOUNT")).click();
        driver.findElement(By.id("email")).sendKeys("bcomqa@gmail.com");
        driver.findElement(By.id("pw-input")).sendKeys("1bcom234");
        driver.findElement(By.id("sign-in")).click();

        WebElement element = driver.findElement(By.linkText("JEWELRY & ACCESSORIES"));
        Actions action = new Actions(driver);

        action.moveToElement(element).build().perform();
        driver.findElement(By.linkText("Bracelets")).click();

        driver.close();
        driver.quit();





    }
}
