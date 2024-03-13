package TestCase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProduct extends BaseTest {
    @Test
    public void GetPrice () {
        // pilih category laptop
        WebElement laptop = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Laptops']")));
        laptop.click();

        // pilih laptop pertama
        WebElement firstLaptop = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Sony vaio i5']")));
        firstLaptop.click();

        //masukan laptop ke cart
        WebElement addtoCart = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Add to cart']")));
        addtoCart.click();

        //menunggu alertnya muncul
        Alert alert = explicitWait.get().until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertTrue(alertMessage.equals("Product added"));
        alert.accept();

        //ke menu cart
        driver.get().findElement(By.xpath("//a[@id='cartur']")).click();

        // pastikan laptop yang baru diadd ada dicart
        WebElement cartTable = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='tbodyid']/tr[1]/td[.='Sony vaio i5']")));
        Assert.assertTrue(cartTable.getText().contains("Sony vaio i5"), "Laptop not found in cart.");
    }

}

