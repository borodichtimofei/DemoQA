import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ElementsTest extends BaseTest {

    public static final By ELEMENTS = By.xpath("//h5[text()='Elements']");
    public static final By CHECK_BOX = By.xpath("//span[text()='Check Box']");
    public static final By HOME = By.xpath("//span[@class = 'rct-checkbox']");
    public static final By RADIO_BUTTON = By.xpath("//span[text()='Radio Button']");
    public static final By YES_BUTTON = By.xpath("//label[@for= 'yesRadio']");
    public static final By IMPRESSIVE_BUTTON = By.xpath("//label[@for= 'impressiveRadio']");
    public static final By CHECK_BOX_MESSAGE = By.id("result");
    public static final By RADIO_BUTTON_MESSAGE = By.xpath("//span[@class= 'text-success']");
    String baseURL = "https://demoqa.com/";
    String expectedMessageCheckBox = "You have selected : home desktop notes commands documents workspace " +
            "react angular veu office public private classified general downloads wordFile excelFile";

    @Test
    public void elementsSelection() {
        driver.get(baseURL);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", driver.findElement(ELEMENTS));
        driver.findElement(ELEMENTS).click();
        driver.findElement(CHECK_BOX).click();
        driver.findElement(HOME).click();
        String actualMessageCheckBox = driver.findElement(CHECK_BOX_MESSAGE).getText().replace("\n", " ");
        assertEquals(actualMessageCheckBox, expectedMessageCheckBox, "Element unselected");
        driver.findElement(RADIO_BUTTON).click();
        driver.findElement(IMPRESSIVE_BUTTON).click();
        assertEquals(driver.findElement(RADIO_BUTTON_MESSAGE).getText(), "Impressive", "Element unselected");
        driver.findElement(YES_BUTTON).click();
        assertEquals(driver.findElement(RADIO_BUTTON_MESSAGE).getText(), "Yes", "Element unselected");
    }
}
