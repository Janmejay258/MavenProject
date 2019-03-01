package com.actitime.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
   @FindBy(name="username")
   private  WebElement userNameEdt;
  @FindBy(name="pwd")
  private  WebElement PasswordEdt;
   @FindBy(id="loginButton")
   private  WebElement loginBtn;
   public void loginApp(String username,String password) throws Throwable {
	
	   userNameEdt.sendKeys(username);
	   PasswordEdt.sendKeys(password);
	   loginBtn.click();
   }

}
