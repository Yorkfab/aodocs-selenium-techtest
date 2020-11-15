package selenium.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import selenium.driver.Browser;
import selenium.driver.WebDriverUtility;
import selenium.webPage.ContactAODocsPage;
import selenium.webPage.GooglePage;
import selenium.utils.Utils;


public class TestAodocs {

    @Test
    public void AODocsDemo() {

        //Ouverture du nagivateur Chrome
        WebDriver webDriver = new WebDriverUtility().getWebDriver(Browser.CHROME);

        //Jeux de données
        String nomRechercher = "AODocs";
        String prenom = "Fabrice-York";
        String adresseEmail = new Utils().genererMail();
        String compagnie = "YorkFab COMP";
        String compagnieSize = "0-4 employees";

        //Messages d'erreur à vérifier
        String msgErreur1 = "Please complete this required field.";
        String msgErreur2 = "Please select an option from the dropdown menu.";
        String msgErreur3 = "Please complete all required fields.";

        try {
            //Ouverture site google
            webDriver.get("https://www.google.fr/");
            new GooglePage(webDriver)._rechercheGoogle(nomRechercher) // Recherche du site AODocs sur google
                    ._clickToRequesDemo() // Clic sur le bouton "Resquest Demo
                    ._saisirContactUs(prenom, adresseEmail, compagnie, compagnieSize); //Saisi du formulaire contactUS

            //Vérification des messages d'erreurs
            ContactAODocsPage contact = new ContactAODocsPage(webDriver);
            Assertions.assertTrue(contact._verifierMessagesErreurs(msgErreur1), "Le message d'erreur n'est pas affiché");
            Assertions.assertTrue(contact._verifierMessagesErreurs(msgErreur2), "Le message d'erreur n'est pas affiché");
            Assertions.assertTrue(contact._verifierMessagesErreurs(msgErreur3), "Le message d'erreur n'est pas affiché");

        } finally {

            new WebDriverUtility().closeWebDriver(webDriver);
        }

    }
}
