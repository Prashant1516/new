package Seleniumpractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
    WebDriver driver;
    public Loginpage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userEmail")
    WebElement username;
    @FindBy(id="userPassword")
    WebElement pass;
    @FindBy(id="login")
    WebElement login;

    public void User_name(String email, String password)
    {
     username.sendKeys(email);
     pass.sendKeys(password);
     login.click();
    }
    public void Website()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }
}
