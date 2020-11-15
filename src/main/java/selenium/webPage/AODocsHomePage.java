package selenium.webPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AODocsHomePage {

    protected static WebDriver driver;
    private By btnResquestDemo = By.xpath("//*[text()='Request a demo']");


    public AODocsHomePage(WebDriver driver) {

        this.driver = driver;
    }


    /**
     * Methode qui clic sur le bouton "Request Demo"
     *
     * @return L'objet ContactAODocsPage
     * @throws Exception
     */
    public ContactAODocsPage _clickToRequesDemo() {

        driver.findElement(btnResquestDemo).click();
        return new ContactAODocsPage(driver);
    }
}
