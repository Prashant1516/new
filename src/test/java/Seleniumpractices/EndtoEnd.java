package Seleniumpractices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class EndtoEnd {
    public static void main(String[] args) {
        String prodtocart = "ZARA COAT 3";
        WebDriver driver = new ChromeDriver();
      //  driver.get("https://rahulshettyacademy.com/client");
        Loginpage loginpage = new Loginpage(driver);
        loginpage.Website();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
//        driver.findElement(By.id("userEmail")).sendKeys("prashant1234@test.com");
//        driver.findElement(By.id("userPassword")).sendKeys("Prashant123!");
//        driver.findElement(By.id("login")).click();
        loginpage.User_name("prashant1234@test.com","Prashant123!");
        Reusable reusable = new Reusable(driver);
        reusable.Elementtoappear(By.cssSelector(".container"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".container")));

        //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        Catelogue catelogue=new Catelogue(driver) ;
        catelogue.Getproducts();
//        WebElement a = products.stream().filter(prod ->
//                prod.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(prodtocart)).findFirst().orElse(null);
        catelogue.Getprodbyname(prodtocart);
//        a.findElement(By.cssSelector(".btn.w-10.rounded")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        catelogue.Addproducttocart(prodtocart);
       reusable.Elementtoappear(By.id("toast-container"));
        Cart cart=new Cart(driver);
        cart.Click_to_add_to_cart();
       // driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
        //reusable.Elementtoappear(By.id("toast-container"));

//        List <WebElement> a = driver.findElements(By.cssSelector("[class='cartSection'] h3"));
//        Boolean d= a.stream().anyMatch(we->we.getText().equalsIgnoreCase("ZARA COAT 3"));
//        Assert.assertTrue(d);
        cart.Verifycart();
        driver.findElement(By.cssSelector(".totalRow button")).click();
        driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("india");
       List<WebElement> dropdown= driver.findElements(By.xpath(".ta-item.list-group-item.ng-star-inserted"));
        Select Dropdown= new Select((WebElement) dropdown);
        Dropdown.selectByValue("india");

    }
}
