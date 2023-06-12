package Seleniumpractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Cart {
    WebDriver driver;
    public Cart(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//button[@routerlink='/dashboard/cart']")
    WebElement Add_to_cart_button;
   @FindBy(css = "[class='cartSection'] h3")
   List<WebElement> Cart_list;
    public void Click_to_add_to_cart()
    {
        Add_to_cart_button.click();
    }
    public void Verifycart()
    {
        //List<WebElement> a = driver.findElements(By.cssSelector("[class='cartSection'] h3"));
        Boolean d= Cart_list.stream().anyMatch(we->we.getText().equalsIgnoreCase("ZARA COAT 3"));
        Assert.assertTrue(d);
    }
}
