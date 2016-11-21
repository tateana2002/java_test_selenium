import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class MozilaGoogle {
    ChromeDriver wd;
    
    @Before
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void MozilaGoogle() {
        wd.get("https://www.google.co.il/?gfe_rd=cr&ei=VfguWKvLBqXH8AfLqbzIDg");
        wd.findElement(By.id("gb")).click();
        wd.findElement(By.name("btnK")).click();
        wd.findElement(By.id("lst-ib")).click();
        wd.findElement(By.id("lst-ib")).sendKeys("погода в москве");
        wd.findElement(By.cssSelector("div.sbqs_c")).click();
    }
    
    @After
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(ChromeDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
