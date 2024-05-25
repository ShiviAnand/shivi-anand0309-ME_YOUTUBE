/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Wrapperclass {

    ChromeDriver driver;

    Wrapperclass(ChromeDriver driver){
        this.driver = driver;
    }
   
    public void scrollToElement(WebElement ele){
        Actions act=  new Actions(driver);
        act.scrollToElement(ele).perform();
    }
    public void scrollByCoordinates(int y){
       JavascriptExecutor js = (JavascriptExecutor)driver;
       js.executeScript("window.scrollBy(0,y)", "");
    }
    public void clickOnElement(WebElement ele){
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.visibilityOf(ele)).click();
      
    }
    public void waitForElement(WebElement ele){
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.visibilityOf(ele));
      
    }
}