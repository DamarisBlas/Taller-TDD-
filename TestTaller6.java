package org.example;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTaller6 {
    private WebDriver driver;

/*

 */

    public TestTaller6() {
    }

    @BeforeTest
    public void setBaseURL() throws Exception {
        String path = "C:\\Users\\DAMARIS\\Documents\\2023\\2\\gestion\\ChromeWebDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();

    }
    @Test
    public void testCase1() {
        // Caso de Prueba 1: Búsqueda exitosa de artículos
        driver.get("https://www.dzone.com/");

        // Realizar una búsqueda exitosa
        String keyword = "Selenium";
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search-box']"));
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.RETURN);

        // Verificar los resultados de la búsqueda
        WebElement searchResults = driver.findElement(By.xpath("//div[@class='search-results']")); // Ajustar el xpath

    }

    @Test
    public void testCase2() {
        // Caso de Prueba 2: Búsqueda sin resultados
        driver.get("https://www.dzone.com/");

        // Realizar una búsqueda sin resultados
        String keyword = "PalabraNoExistente";
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search-box']")); // Ajustar el xpath
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.RETURN);

        // Verificar que se muestra el mensaje de búsqueda sin resultados
        WebElement noResultsMessage = driver.findElement(By.xpath("//div[@class='no-results-message']")); // Ajustar el xpath

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}
