package day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNG1 {
	WebDriver driver;
  @Test
  public void testa() throws InterruptedException {
		//driver.get("http://localhost/ws/ecshop/upload/index.php");
	    driver.get("http://localhost/ecshop/upload/index.php");
		driver.findElement(By.xpath(".//*[@id='ECS_MEMBERZONE']/a[1]/img")).click();
		driver.findElement(By.name("username")).sendKeys("luoxixi");
		Thread.sleep(3000); 
		driver.findElement(By.name("password")).sendKeys("luoxixi123456");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);  
		driver.findElement(By.linkText("�˳�")).click();
  }

  @BeforeMethod
  public void beforeMethod() {
	FirefoxProfile profile = new FirefoxProfile();
	////����flash
	profile.setPreference("dom.ipc.plugins.enabled", false);
	driver = new FirefoxDriver(profile);
	//��������
	driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
