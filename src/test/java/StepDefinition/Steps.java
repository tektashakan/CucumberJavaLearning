package StepDefinition;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;


public class Steps {




    WebDriver driver;
    @Given("^Login sayfası açılır$")
    public void login_sayfas_alr() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.netflix.com/tr/");


    }

    @When("^Kullanıcı adı girilir$")
    public void kullanc_ad_girilir() throws Throwable {
        driver.findElement(By.id("id_email_hero_fuji")).click();
        driver.findElement(By.id("id_email_hero_fuji")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//body/div[@id='appMountPoint']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]")).click();
        Thread.sleep(1500);
    }

    @And("^Şifre bilgisi girilir$")
    public void sifre_bilgisi_girilir() throws Throwable {
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[contains(text(),'İleri')]")).click();
        Thread.sleep(1500);
        String text =driver.findElement(By.xpath("//span[contains(text(),'Parolanız 4 ila 60 karakter olmalıdır.')]")).getText();
        System.out.println("İlk mesaj"+ ":" + text);
        String text2 ="Parolanız 4 ila 60 karakter olmalıdır.";
        Assert.assertEquals(text,text2);

        driver.findElement(By.id("id_password")).click();
    }

    @And("^Login buton tıklanır$")
    public void login_buton_tklanr() throws Throwable {
        driver.findElement(By.id("id_password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[contains(text(),'İleri')]")).click();
    }

    @Then("^Login ana ekranı açılır$")
    public void login_ana_tklanr() throws Throwable {
        driver.findElement(By.cssSelector(".nf-message-contents")).click();
        String text3 =driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div[2]/div/form/div/div[1]/div/div[2]/span/b")).getText();
        System.out.println("İkinci mesaj"+":" + text3);
        String text4 ="Parola yanlış.";
        Assert.assertEquals(text3,text4);

        driver.quit();
    }

}