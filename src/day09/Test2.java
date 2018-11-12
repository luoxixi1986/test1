package day09;
//TimeUnit 表示给定时间段,TimeUnit.SECONDS

import java.util.concurrent.TimeUnit;
//用junit框架，@Before @Test @After，初始化，步骤，结束都基于junit
import org.junit.*;
//junit断言写法 assertEquals
import static org.junit.Assert.*;
//selenium 驱动driver private WebDriver driver
import org.openqa.selenium.*;
//谷歌驱动new ChromeDriver();
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
   /* driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
	//启动Chrome浏览器
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe"); 
	driver = new ChromeDriver();
    baseUrl = "http://localhost/";
    //此处设置的等待时间 是针对全局设置的，webdriver中执行所有命令 的超时时间都设置为30秒了
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTC009() throws Exception {
    driver.get(baseUrl + "/ecshop/upload/index.php");
    driver.findElement(By.id("keyword")).clear();
    driver.findElement(By.id("keyword")).sendKeys("a");
    driver.findElement(By.name("imageField")).click();
    Thread.sleep(3000);
    String gn = driver.findElement(By.cssSelector("p > a")).getText();
    System.out.println("预期"+gn);
    driver.findElement(By.cssSelector("p > a")).click();
    //p.f_l p是标签，f_l值
    assertEquals(gn, driver.findElement(By.cssSelector("p.f_l")).getText());
    System.out.println("实际"+gn);
    //休眠3s钟
    //Thread.sleep(3000);  
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
