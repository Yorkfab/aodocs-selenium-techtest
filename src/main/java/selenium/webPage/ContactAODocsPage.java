package selenium.webPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactAODocsPage {

    protected static WebDriver driver;
    private By firstname = By.name("firstname");
    private By email = By.name("email");
    private By company = By.name("company");
    private By company_size = By.name("company_size__c");
    private By Iagree = By.name("LEGAL_CONSENT.subscription_type_4455113");
    private By submit = By.xpath("//input[contains(@value,'Submit')]");


    public ContactAODocsPage(WebDriver driver) {

        this.driver = driver;
    }


    /**
     * Méthode qui saisi la page Contact Us et clic sur le bouton "Submit"
     *
     * @param firstname
     * @param adresseEmail
     * @param compagnie
     * @param compagnieSize
     * @return ContactAODocsPage
     * @throws Exception
     */
    public ContactAODocsPage _saisirContactUs(String firstname, String adresseEmail, String compagnie, String compagnieSize) {

        //Formulaire Contact Us
        driver.findElement(this.firstname).sendKeys(firstname); // On saisi le prenom
        driver.findElement(this.email).sendKeys(adresseEmail);//On saisi l'adresse email généré
        driver.findElement(this.company).sendKeys(compagnie); //On saisi le nom de la compagnie
        new Select(driver.findElement(this.company_size)).selectByVisibleText(compagnieSize);//On selection la taille d'une compagnie

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        driver.findElement(this.Iagree).click();//On clic sur le checkbox I agree...
        driver.findElement(this.submit).click();

        return this;
    }

    /**
     * Méthode pour vérifier les messages d'erreur sur le formulaire
     *
     * @param messages
     * @return true or false
     * @throws Exception
     */
    public Boolean _verifierMessagesErreurs(String messages) {

        WebElement messagesErreurs = driver.findElement(By.xpath("//*[text()='" + messages + "']"));

        return messagesErreurs.isDisplayed();
    }
}
