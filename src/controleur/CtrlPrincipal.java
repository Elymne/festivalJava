package controleur;

/**
 * @author Sacha Djurdjevic
 */
import static controleur.EnumAction.*;
import javax.swing.JOptionPane;
import modele.jdbc.Jdbc;

public class CtrlPrincipal {

    private CtrlLesRepresentations ctrlLesRepresentations = null;
    private CtrlLesVentes ctrlLesVentes = null;
    private CtrlMenu ctrlMenu = null;
    private CtrlAuthentification ctrlAuthentification = null;

    /**
     * Méthode qui instancie le controleur Authentification par défaut(si il ne
     * l'a pas été) Cette méthode est s'exécute à chaque fois que l'utilisateur
     * lance l'application
     */
    public void action() {
        if (ctrlAuthentification == null) {
            ctrlAuthentification = new CtrlAuthentification(this);
        }
        ctrlAuthentification.getVue().setEnabled(true);
        ctrlAuthentification.getVue().setVisible(true);
    }

    /**
     * Méthode qui permet d'instancier un controleur dont le constructeur
     * n'admet pas de paramètres Le paramètre action défini quel controleur sera
     * lancé Ex : unControleur.action(MENU_REPRESENTATION); lancera la méthode
     * MenuRepresentation() qui elle même instancie le controleur Menu
     *
     * @param action
     */
    public void action(EnumAction action) {
        switch (action) {
            case MENU_REPRESENTATION: // Permet d'avoir accès à la liste des représentations
                MenuRepresentation();
                break;
            case MENU_REPRESENTATION_QUITTER:    // Permet de revenir au menu
                menuQuitterRepresentation();
                break;
            case MENU_QUITTER: // Permet de quitter l'application
                menuQuitter();
                break;
            case REPRESENTATION_VENTE_QUITTER: // Permet de revenir à la liste des représentations
                representationVenteQuitter();
                break;
            case MENU_DECONNEXION: //Permet de changer d'utilisateur
                deconnexionMenu();
                break;
            case MENU_CONNEXION: //Permet d'avoir accès au menu depuis le controleur connexion
                connexionMenu();
                break;
        }
    }

    /**
     * Méthode qui permet d'instancier un controleur dont le contructeur admet
     * un paramètre de type String Le paramètre action défini quel controleur
     * sera lancé Le paramètre var stocke une variable de type String qui sera
     * envoyé au controleur
     *
     * @param action
     * @param var
     */
    public void action(EnumAction action, String var) {
        switch (action) {
            case REPRESENTATION_VENTE: //activation vueVente depuis la vueRepresentation
                representationVente(var);
                break;
        }
    }

    /**
     * Méthode qui permet de se déconnecter de l'application et de quitter
     * l'application
     */
    private void menuQuitter() {
        try {
            Jdbc.getInstance().deconnecter();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "CtrlPrincipal - fermeture connexion BD", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.exit(0);
        }
    }

    /**
     * Permet de passer de la vue Menu à la vue Representation
     */
    private void MenuRepresentation() {
        if (ctrlLesRepresentations == null) {
            ctrlLesRepresentations = new CtrlLesRepresentations(this);
        }
        ctrlMenu.getVue().setEnabled(false);
        ctrlLesRepresentations.getVue().setVisible(true);
    }

    /**
     * Permet de passer de la vue Representation à la vue Menu
     */
    private void menuQuitterRepresentation() {
        if (ctrlMenu == null) {
            ctrlMenu = new CtrlMenu(this);
        }
        ctrlLesRepresentations.getVue().setVisible(false);
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true); // Inutile je crois
    }

    /**
     * Permet de passer de la vue Representation à la vue Vente
     *
     * @param groupe
     */
    private void representationVente(String groupe) {
        if (ctrlLesVentes == null) {
            ctrlLesVentes = new CtrlLesVentes(this, groupe);
        }
        ctrlLesVentes.getVue().setVisible(true);
        ctrlLesRepresentations.getVue().setEnabled(false);
    }

    /**
     * Permet de passer de la vue Vente à la vue Representation
     */
    private void representationVenteQuitter() {
        if (ctrlLesRepresentations == null) {
            ctrlLesRepresentations = new CtrlLesRepresentations(this);
        }
        ctrlLesVentes.getVue().setVisible(false);
        ctrlLesVentes = null;
        ctrlLesRepresentations.getVue().setEnabled(true);
        ctrlLesRepresentations.getVue().setVisible(true); // Inutile je crois
    }

    /**
     * Permet de passer de la vue Authentification à la vue Menu
     */
    private void connexionMenu() {
        if (ctrlMenu == null) {
            ctrlMenu = new CtrlMenu(this);
        }
        ctrlAuthentification.getVue().setVisible(false);
        ctrlAuthentification = null;
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true);
    }

    /**
     * permet de passer de la vue Menu à la vue Authentification
     */
    private void deconnexionMenu() {
        if (ctrlAuthentification == null) {
            ctrlAuthentification = new CtrlAuthentification(this);
        }
        ctrlMenu.getVue().setVisible(false);
        ctrlMenu = null;
        ctrlAuthentification.getVue().setEnabled(true);
        ctrlAuthentification.getVue().setVisible(true);
    }
}
