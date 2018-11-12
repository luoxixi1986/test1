package day09;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void testTC009() throws Exception {
    driver.get(baseUrl + "/ecshop/upload/index.php");
    driver.findElement(By.cssSelector("#ECS_MEMBERZONE > a > img")).click();
    Thread.sleep(1000);
    String n = "luoxixi";
    String p = "luoxixi123456";
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys(n);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(p);
    driver.findElement(By.name("submit")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("退出")).click();
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("#ECS_MEMBERZONE > a > img")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys(n);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(p);
    driver.findElement(By.name("submit")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("退出")).click();
    System.out.println("============");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
