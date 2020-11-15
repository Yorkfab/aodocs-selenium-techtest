package selenium.webPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GooglePage {

    protected static WebDriver driver;
    private By champsGoogleRecherche = By.xpath("//input[contains(@title,'Search')]");
    private By urlToClick = By.xpath("//*[text()='AODocs: Cloud Document Services Platform']");


    public GooglePage(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Méthode qui recherche sur google et clic sur AODocs
     *
     * @param element
     * @return L'objet AODocsHomePage
     * @throws Exception
     */
    public AODocsHomePage _rechercheGoogle(String element) {

        driver.findElement(champsGoogleRecherche).sendKeys(element + Keys.ENTER);
        driver.findElement(urlToClick).click();

        return new AODocsHomePage(driver);
    }


}
