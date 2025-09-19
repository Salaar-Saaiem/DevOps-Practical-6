package com.example;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OpenChromeTest {

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }
    @Test
    void openLinkedIn() {
        String url = "https://www.linkedin.com/in/salaarsaaiem525/";
        driver.get(url);

        // Verification: LinkedIn's title usually contains "LinkedIn"
        String title = driver.getTitle();
        Assertions.assertTrue(title.contains("LinkedIn"), "Page title should contain 'LinkedIn'");
        System.out.println("Opened: " + url + " — Title: " + title);
    }
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
