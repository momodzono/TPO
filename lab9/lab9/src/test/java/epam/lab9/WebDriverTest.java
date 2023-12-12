package epam.lab9;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class WebDriverTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://animego.org/");

        By filterButtonSelector = By.xpath("//*[@id=\"filter\"]/div[2]/form/div[2]/div[2]/button");
        WebElement filterButton = driver.findElement(filterButtonSelector);
        filterButton.click();

        By vampButtonSelector = By.xpath("//*[@id=\"filter\"]/div[2]/form/div[2]/div[2]/div/div/span[3]/span");
        WebElement vampButton = driver.findElement(vampButtonSelector);
        vampButton.click();

        By searchButtonSelector = By.xpath("//*[@id=\"filter\"]/div[2]/form/div[8]/button");
        WebElement searchButton = driver.findElement(searchButtonSelector);
        searchButton.click();

        List<WebElement> animesElements = driver.findElements(By.cssSelector(".animes-list-item"));
        List<WebElement> genresElements = driver.findElements(By.cssSelector(".anime-genre > a"));

        List<String> vimpires = genresElements
                .stream()
                .map(el -> el.getAttribute("title"))
                .filter(el -> el.equals("Вампиры"))
                .collect(Collectors.toList());

        System.out.println("All is " + (animesElements.size() == vimpires.size() ? "good" : "bad"));

//    driver.quit();
    }
}
