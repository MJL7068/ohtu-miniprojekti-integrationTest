package integration;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Stepdefs {

    WebDriver driver = new ChromeDriver();
    String baseUrl = "https://pure-coast-94327.herokuapp.com/";

    @Given("^uusi viite is selected$")
    public void uusi_viite_is_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("Lisää uusi lähdeviite"));
        element.click();
    }
    
    @Given("^user is in the main page and there is a reference with the title \"([^\"]*)\" in the database$")
    public void user_is_in_the_main_page_and_there_is_a_reference_with_the_title_testireferenssi(String arg1) throws Throwable {
        driver.get(baseUrl);
        pageHasContent("Lähdeviitteet");

        teeTestiReferenssi(arg1);
    }
    
    @When("^title \"([^\"]*)\" is entered in the edit-form$")
    public void title_is_entered_in_the_edit_form(String arg1) throws Throwable {
        
    }
     
    @When("^button with the text \"([^\"]*)\" next to the reference with the title \"([^\"]*)\" is pressed$")
    public void button_poista_next_to_the_testireferenssi_is_pressed(String arg1, String arg2) throws Throwable {
        WebElement element = driver.findElement(By.id(arg2));
        element.submit();
    }

    @When("^\"([^\"]*)\" is selected and title \"([^\"]*)\" and author \"([^\"]*)\" and publisher \"([^\"]*)\" and year \"([^\"]*)\" and address \"([^\"]*)\" and edition \"([^\"]*)\" are entered$")
    public void book_is_selected_and_nimi_and_kirjoittaja_and_publisher_and_julkaisuvuosi_and_julkaisijan_osoite_and_painos_are_entered(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        pageHasContent("Lisää uuden lähdeviitteen tiedot");

        Select dropdown = new Select(driver.findElement(By.name("entrytype")));
        dropdown.selectByVisibleText(arg1);
        
        WebElement element = driver.findElement(By.name("entrykey"));
        element.sendKeys("1");

        element = driver.findElement(By.name("author"));
        element.sendKeys(arg3);

        element = driver.findElement(By.name("title"));
        element.sendKeys(arg2);
        
        element = driver.findElement(By.name("publisher"));
        element.sendKeys(arg4);
        
        element = driver.findElement(By.name("year"));
        element.sendKeys(arg5);
        
        element = driver.findElement(By.name("address"));
        element.sendKeys(arg6);
        
        element = driver.findElement(By.name("edition"));
        element.sendKeys(arg7);
        
        sleep(2);
        
        element = driver.findElement(By.xpath("//button[contains(.,'Lisää')]"));

        element.submit();
    }
    
    @When("^\"([^\"]*)\" is selected and title \"([^\"]*)\" and author \"([^\"]*)\" and journal \"([^\"]*)\" and year \"([^\"]*)\" and volume \"([^\"]*)\" and number \"([^\"]*)\" are entered$")
    public void article_is_selected_and_title_and_author_and_journal_and_year_and_volume_and_number_are_entered(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        pageHasContent("Lisää uuden lähdeviitteen tiedot");

        Select dropdown = new Select(driver.findElement(By.name("entrytype")));
        dropdown.selectByVisibleText(arg1);
        
        WebElement element = driver.findElement(By.name("entrykey"));
        element.sendKeys("1");

        element = driver.findElement(By.name("author"));
        element.sendKeys(arg3);

        element = driver.findElement(By.name("title"));
        element.sendKeys(arg2);
        
        element = driver.findElement(By.name("journal"));
        element.sendKeys(arg4);
        
        element = driver.findElement(By.name("year"));
        element.sendKeys(arg5);
        
        element = driver.findElement(By.name("volume"));
        element.sendKeys(arg6);
        
        element = driver.findElement(By.name("number"));
        element.sendKeys(arg7);
        
        sleep(2);
        
        element = driver.findElement(By.xpath("//button[contains(.,'Lisää')]"));

        element.submit();
    }
    
    @When("^\"([^\"]*)\" is selected and title \"([^\"]*)\" and author \"([^\"]*)\" and booktitle \"([^\"]*)\" and year \"([^\"]*)\" and pages \"([^\"]*)\" and publisher \"([^\"]*)\" are entered$")
    public void inproceedings_is_selected_and_title_and_author_and_booktitle_and_year_and_pages_and_publisher_are_entered(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        pageHasContent("Lisää uuden lähdeviitteen tiedot");

        Select dropdown = new Select(driver.findElement(By.name("entrytype")));
        dropdown.selectByVisibleText(arg1);
        
        WebElement element = driver.findElement(By.name("entrykey"));
        element.sendKeys("GvG00");

        element = driver.findElement(By.name("author"));
        element.sendKeys(arg3);

        element = driver.findElement(By.name("title"));
        element.sendKeys(arg2);
        
        element = driver.findElement(By.name("booktitle"));
        element.sendKeys(arg4);
        
        element = driver.findElement(By.name("year"));
        element.sendKeys(arg5);
        
        element = driver.findElement(By.name("pages"));
        element.sendKeys(arg6);
        
        element = driver.findElement(By.name("publisher"));
        element.sendKeys(arg7);
        
        sleep(2);
        
        element = driver.findElement(By.xpath("//button[contains(.,'Lisää')]"));

        element.submit();
    }

    @Then("^the reference is added and user is returned to the front page$")
    public void the_reference_is_added_and_user_is_returned_to_the_front_page() throws Throwable {
        pageHasContent("Lähdeviitteet");
        
        sleep(1);
    }
    
    @Then("^the reference with the title \"([^\"]*)\" is removed$")
    public void the_reference_with_the_title_is_removed(String arg1) throws Throwable {
        assertTrue(!driver.getPageSource().contains(arg1));
    }
    
    @Then("^there is a reference with the title \"([^\"]*)\" in the database$")
    public void there_is_a_reference_with_the_title_in_the_database(String arg1) throws Throwable {
        
    }
    
    public void teeTestiReferenssi(String title) throws Throwable {
        WebElement element = driver.findElement(By.linkText("Lisää uusi lähdeviite"));
        element.click();
        
        book_is_selected_and_nimi_and_kirjoittaja_and_publisher_and_julkaisuvuosi_and_julkaisijan_osoite_and_painos_are_entered("book", title, "kirjoittaja", "julkaisija", "1999", "osoite", "22");
    
        pageHasContent("Lähdeviitteet");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
