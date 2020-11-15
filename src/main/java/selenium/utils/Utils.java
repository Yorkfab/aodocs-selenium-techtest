package selenium.utils;


public class Utils {

    /**
     * Méthode pour générer l'adresse email
     *
     * @return adresse mail
     * @throws Exception
     */
    public String genererMail() {

        String chars = "abcdefghijklmnopqrstuvwxyz"; // Tu supprimes les lettres dont tu ne veux pas
        String pass = "a";
        String pass2 = "@gmail.fr";
        String mail;

        for (int x = 0; x < 7; x++) {
            int i = (int) Math.floor(Math.random() * 26); // Si tu supprimes des lettres tu diminues ce nb
            pass = chars.charAt(i) + pass;
        }
        mail = pass + pass2;
        return mail;
    }


}
