package day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNG9 {
	WebDriver driver;
  @Test
  public void login() throws InterruptedException {
	  //后台地址：http://localhost/ecshop/upload/admin/index.php
	  driver.get("http://localhost/ecshop/upload/index.php");
	  driver.findElement(By.xpath(".//*[@id='ECS_MEMBERZONE']/a[1]/img")).click();
	  driver.findElement(By.name("username")).sendKeys("luoxixi");
	  driver.findElement(By.name("password")).sendKeys("luoxixi123456");
	  driver.findElement(By.name("submit")).click();
	  Thread.sleep(3000);
  }
  
  @Test(dependsOnMethods={"message"})
  public void logout() throws InterruptedException {
	  driver.findElement(By.linkText("退出")).click();
	  Thread.sleep(3000);
  }

  @Test(dependsOnMethods={"login"})
  public void message() throws InterruptedException {
	  driver.findElement(By.linkText("留言板")).click();
	  WebElement e = driver.findElement(By.name("user_email"));
	  if (e.getAttribute("value").equals("")){
		  e.sendKeys("a@163.com");
	  }
	  driver.findElements(By.name("msg_type")).get(3).click();
	  driver.findElement(By.name("msg_title")).sendKeys("abc");
	  driver.findElement(By.name("msg_content")).sendKeys("def");
	  driver.findElement(By.xpath("//*[@value='我要留言']")).click();
	  Thread.sleep(3000);
  }
  
  @BeforeClass
  public void beforeMethod() {
	FirefoxProfile profile = new FirefoxProfile();
	profile.setPreference("dom.ipc.plugins.enabled", false);
	driver = new FirefoxDriver(profile);
  }

  @AfterClass
  public void afterMethod() {
	 driver.quit();
  }

}
