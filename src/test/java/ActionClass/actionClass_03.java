package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.WebAutomation.WaitHelper.waitHelper.waitJVM;

public class actionClass_03 {

    @Test

    public  void test_Action003(){

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));

        WebElement close =driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        close.click();

        waitJVM(3000);

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        Actions action = new Actions(driver);

        action.moveToElement(fromCity).click().sendKeys("IXC").build().perform();

        waitJVM(3000);

       List< WebElement> auto_list = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));

       for(WebElement auto : auto_list)

           if (auto.getText().contains("Chandigarh")){
               auto.click();
           }
    }
}
