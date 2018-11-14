package day09;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class Test3 {
	WebDriver driver;
	private boolean acceptNextAlert = true;
	
	@Before
	public void setUp() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.ipc.plugins.enabled", false);
		driver = new FirefoxDriver(profile);
		//浏览器最大化
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testa() throws Exception {
//		a.打开ECShop前台首页
		driver.get("http://localhost//ecshop/upload/index.php");
//		b.输入关键字a
		driver.findElement(By.xpath("//input[@id='keyword']")).sendKeys("a");
//		c.点击”搜索“按钮
		driver.findElement(By.xpath("//input[@name='imageField']")).click();
//		d.点击所有商品中最后一个商品的图片
		driver.findElement(By.xpath("//div[@class='goodsItem'][last()]/a[1]/img")).click();
//		e.点击”加入购物车“
		driver.findElement(By.xpath("//img[contains(@src,'bnt_cat')]")).click();
//		f.等待5秒，将购物车页面中的”购买数量“修改为3
		Thread.sleep(5000);
		WebElement gn = driver.findElement(By.xpath("//input[contains(@id,'goods_number')]"));
		//清空数据
		gn.clear();
		//输入3
		gn.sendKeys("3");	
//		g.等待5秒，点击操作列的”删除“链接
		Thread.sleep(1000);
		//文本是text()='删除'
		driver.findElement(By.xpath("//a[text()='删除']")).click();
//		在提示上点击”确定“
		closeAlertAndGetItsText();
		Thread.sleep(6000);
		Thread.sleep(6000);
		Thread.sleep(6000);
		Thread.sleep(6000);
	}
	  
	//有返回值得，如果是void是无返回值得
	  private String closeAlertAndGetItsText() throws Exception {
		    try {
		    	//获取句柄提示框
		      Alert alert = driver.switchTo().alert();
		      Thread.sleep(5000);
		      //提示框中获取文本
		      String alertText = alert.getText();
		      System.out.println(alertText);
		      Thread.sleep(5000);
		      //acceptNextAlert为true，所有点击确定按钮
		      if (acceptNextAlert) {
		    	  //点击 确定
		        alert.accept();
		      } else {
		    	  //点击 取消
		        alert.dismiss();
		      }
		      return alertText;
		      //不管成功失败都要执行acceptNextAlert为真
		    } finally {
		      acceptNextAlert = true;
		    }
		  }
}
