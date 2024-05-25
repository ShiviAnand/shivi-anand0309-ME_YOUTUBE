package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterTest
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    @Test(description = "click on About ")
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.youtube.com/");
        if(driver.getCurrentUrl().equals("https://www.youtube.com/"))
        {
            System.out.println("Youtube is displayed");
        }
        Thread.sleep(4000);
        
      WebElement target =  driver.findElement(By.xpath("//a[contains(text(),'About')]"));
      Wrapperclass wrt = new Wrapperclass(driver);
      wrt.scrollToElement(target);
      wrt.clickOnElement(target);
      WebElement text = driver.findElement(By.xpath("//section[@class='ytabout__content']//p[2]"));
      System.out.println(text.getText());
        
        System.out.println("end Test case: testCase01");

    }
    
    @Test(description = "click on Movies")
    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.youtube.com/");
        if(driver.getCurrentUrl().equals("https://www.youtube.com/"))
        {
            System.out.println("Youtube is displayed");
        }
        
      WebElement movies = driver.findElement(By.xpath("//yt-formatted-string[text()='Movies']"));
      Wrapperclass wrc= new Wrapperclass(driver);
      wrc.scrollToElement(movies);
      wrc.clickOnElement(movies); 
       boolean flag =true;
        while(flag){
            Thread.sleep(4000);
           WebElement ls = driver.findElement(By.xpath("//ytd-browse[@role='main']//button[@aria-label='Next']"));
            
                if(ls.isDisplayed()){
                    wrc.clickOnElement(ls);
                }   else{
                    flag = false;
                }  
             }   
        System.out.println("end Test case: testCase02");

    }
    @Test
    public  void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.youtube.com/");
        if(driver.getCurrentUrl().equals("https://www.youtube.com/"))
        {
            System.out.println("Youtube is displayed");
        }
             
      WebElement music = driver.findElement(By.xpath("//a[@id='endpoint' and @title='Music']"));
      Wrapperclass wrt =  new Wrapperclass(driver);
      wrt.clickOnElement(music);
      Thread.sleep(4000);
       wrt.waitForElement(driver.findElement(By.xpath("//h1[@class='style-scope ytd-topic-channel-details-renderer']")));
       
        boolean flag =true;
        while(flag){
         WebElement ls = driver.findElement(By.xpath("(//*[@id='right-arrow']/ytd-button-renderer/yt-button-shape/button)[1]"));
           
           if(ls.isDisplayed()){
                     wrt.clickOnElement(ls);
                }   else{
                    flag = false;
                }  
             }   

       WebElement text = driver.findElement(By.xpath("//h3[contains(text(),'Bollywood Dance Hitlist')]//following-sibling::p[@id='video-count-text']"));
       System.out.println(text.getText());
       Assert.assertEquals( text.getText(), "50 tracks", "playlist is not matching");
        System.out.println("end Test case: testCase03");

    }
    



}
