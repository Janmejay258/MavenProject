package com.actitime.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.framework.BaseClass;
import com.actitime.objectrepository.CreatTask;
import com.actitime.objectrepository.Home;

import com.actitime.framework.*;;
@Listeners(com.actitime.framework.LisetenerTest.class)
public class CreatCustomerTest extends BaseClass{
	@Test(enabled=true)
	public void creatCustomerTest() throws Throwable {
		Home h=PageFactory.initElements(driver, Home.class);
		h.clickTaskImg();
		 String custmorName=lib.getExcelData("Sheet1",0, 6);
		 String projectName=lib.getExcelData("Sheet1", 1, 3);
		 String massg=lib.getExcelData("Sheet1", 1, 2);
		
		CreatTask tsk=PageFactory.initElements(driver, CreatTask.class);
		tsk.taskWork(custmorName, projectName, massg);
		String expSubText = "1 new task was added to the customer";
		String actualText = driver.findElement(By.xpath("//table/tbody/tr[3]/td[@class='pagetitle']")).getText();
		if (actualText.contains(expSubText)) {
			System.out.println("Custmor Is Created == Pass");
		} else {
			System.out.println("Custmor Is not Created == Fail");
			
			
		}
	}
	@Test(enabled=false)
	public void deleteCustmoreTest() throws Throwable {
		  //searchTasks
		 
				driver.findElement(By.xpath("//a[@class='content tasks']/img[@class='sizer']")).click();
				Thread.sleep(3000);
				driver.findElement(By.name("searchTasks")).click();
				driver.findElement(By.xpath("//table/tbody/tr[3]/td[7]/input")).click();
				driver.findElement(By.xpath("//table/tbody/tr[4]/td[7]/input")).click();
				driver.findElement(By.xpath("//table/tbody/tr[5]/td[7]/input")).click();
				driver.findElement(By.xpath("//table/tbody/tr[6]/td[7]/input")).click();
				driver.findElement(By.xpath("//table/tbody/tr[7]/td[7]/input")).click();
				driver.findElement(By.xpath("//input[@value='Delete Selected Tasks']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@value='Delete Tasks']")).click();
				Thread.sleep(8000);
				driver.close();
		  
		  
	  }
	 @Test(enabled=false)
	  public void CustmorDeleteTest() throws Throwable{
		  Filelib lib =new Filelib();
			 String url= lib.getPropertyKeyValue("url");
			 String userName=lib.getPropertyKeyValue("user");
			 String password=lib.getPropertyKeyValue("password");
			 WebDriver driver = new FirefoxDriver();
				driver.get(url);
				driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
				driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
				driver.findElement(By.xpath("//a[text()='Login']")).click();
				driver.findElement(By.xpath("//a[@class='content tasks']/img[@class='sizer']")).click();
				driver.findElement(By.linkText("Projects & Customers")).click();
				driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[2]/td[6]/input")).click();
				driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[4]/td[6]/input")).click();
				driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[6]/td[6]/input")).click();
				driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[8]/td[6]/input")).click();
				driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[10]/td[6]/input")).click();
				driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[12]/td[6]/input")).click();
				driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[14]/td[6]/input")).click();
				driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[16]/td[6]/input")).click();
				//driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[18]/td[6]/input")).click();
				//driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[20]/td[6]/input")).click();
				driver.findElement(By.xpath("//input[@value='Delete Selected']")).click();
				driver.findElement(By.xpath("//input[@value='Delete These Customers']")).click();
			
		
	  }

}
