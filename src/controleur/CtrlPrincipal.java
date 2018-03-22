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
    
    public void action(){
        if(ctrlMenu == null){
            ctrlMenu = new CtrlMenu(this);
            ctrlMenu.getVue().setTitle("Festival");
        }
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true);
    }
    
    // Appel d'un constructeur sans échange de variable
    public void action(EnumAction action) {
        switch (action) {
            case MENU_REPRESENTATION: // activation de vuePresence depuis vueMenu
                MenuRepresentation();
                break;
            case MENU_AUTHENTIFICATION: // activation de vuePresence depuis vueMenu
                MenuAuthentification();
                break;
            case MENU_REPRESENTATION_QUITTER:    // retour à vueMenu depuis la vuePresence
                menuQuitterRepresentation();
                break;
            case MENU_QUITTER: // fin de l'application depuis vueMenu
                menuQuitter();
                break;
            case REPRESENTATION_VENTE_QUITTER:
                representationVenteQuitter();
                break;       
        }

    }
    
    // Appel d'un constructeur avec appel de variable (Nombre : 1, Type : String )
    public void action(EnumAction action, String var){
        switch (action){
            case REPRESENTATION_VENTE: //activation vueVente depuis la vueRepresentation
                representationVente(var);
                break; 
        }
    }
    
    private void menuQuitter(){
        try{
            Jdbc.getInstance().deconnecter();    
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "CtrlPrincipal - fermeture connexion BD", JOptionPane.ERROR_MESSAGE);
        }finally{
            System.exit(0);
        }
    }
    
    
    
    private void MenuRepresentation(){
        if(ctrlLesRepresentations == null){
            ctrlLesRepresentations = new CtrlLesRepresentations(this);
        }
        ctrlMenu.getVue().setEnabled(false);
        ctrlLesRepresentations.getVue().setVisible(true);
    }
    
    private void menuQuitterRepresentation(){
        if(ctrlMenu == null){
            ctrlMenu = new CtrlMenu(this);
        }
        ctrlLesRepresentations.getVue().setVisible(false);
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true); // Inutile je crois
    }
    
        private void MenuAuthentification(){
        if(ctrlMenu == null){
            ctrlMenu = new CtrlMenu(this);
        }
        ctrlAuthentification.getVue().setVisible(false);
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true); // Inutile je crois
    }
    
    
    private void representationVente(String groupe){
        if(ctrlLesVentes == null){
            ctrlLesVentes = new CtrlLesVentes(this, groupe);
        }
        ctrlLesVentes.getVue().setVisible(true);
        ctrlLesRepresentations.getVue().setEnabled(false);
    }
    
    private void representationVenteQuitter(){
        if(ctrlLesRepresentations == null){
            ctrlLesRepresentations = new CtrlLesRepresentations(this);
        }
        ctrlLesVentes.getVue().setVisible(false);
        ctrlLesVentes = null;
        ctrlLesRepresentations.getVue().setEnabled(true);
        ctrlLesRepresentations.getVue().setVisible(true); // Inutile je crois
    }
    
}
