package Seleniumpractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Catelogue extends Reusable{
    WebDriver driver;

    public Catelogue(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".mb-3")
    List<WebElement> productss;
    By productby = By.cssSelector(".container");
    By addtocart= By.cssSelector(".btn.w-10.rounded");
    By toast = By.id("toast-container");
    public List<WebElement> Getproducts()
    {
        Elementtoappear(productby);
        return productss;
    }
    public WebElement Getprodbyname(String prodtocart)
    {
        WebElement a = productss.stream().filter(prod ->
                prod.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(prodtocart)).findFirst().orElse(null);
        return a;
    }
    public void Addproducttocart(String prodtocart)
    {
        WebElement a= Getprodbyname(prodtocart);
             a.findElement(addtocart).click();


    }

}
