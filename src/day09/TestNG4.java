package day09;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;


public class TestNG4 {
  WebDriver driver;
  @Test(dataProvider = "dp3")
  public void f(String kw, String count) throws InterruptedException {
	  //打开前台首页
	  driver.get("http://localhost/ecshop/upload/index.php");
	  Thread.sleep(3000);
	  //输入关键字：形参变量kw的值
	  driver.findElement(By.id("keyword")).sendKeys(kw);
	  Thread.sleep(2000);
	  //点击“搜索”                   
	  driver.findElement(By.name("imageField")).click();
	  Thread.sleep(2000);
	  //断言统计个数:形参变量count的值
	  String c = driver.findElement(By.tagName("b")).getText();
	  assertEquals(c,count);
  }
  @BeforeMethod
  public void beforeMethod() {
	  FirefoxProfile profile = new FirefoxProfile();
	  profile.setPreference("dom.ipc.plugins.enabled", false);
	  driver = new FirefoxDriver(profile);
	  //游览器最大化
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @DataProvider
  //把dp3作为数据源名称
  public Object[][] dp2() {
    return new Object[][] {
      new Object[] { "a", "4" },
      new Object[] { "b", "1" },
      new Object[] { "c", "24" },
    };
  }
//自己指定的数据名称
@DataProvider(name="dp3")
public Object[][] dp3() {
  return new Object[][] {
    new Object[] { "a", "4" },
  };
}
}
