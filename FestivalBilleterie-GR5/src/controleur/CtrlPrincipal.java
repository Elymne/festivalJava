package controleur;

/**
 * @author Sacha Djurdjevic
 */
import static controleur.EnumAction.*;
import javax.swing.JOptionPane;
import modele.jdbc.Jdbc;

public class CtrlPrincipal {
    
    private CtrlLesRepresentations ctrlLesRepresentations = null;
    private CtrlMenu ctrlMenu = null;
    
    public void action(){
        if(ctrlMenu == null){
            ctrlMenu = new CtrlMenu(this);
        }
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true);
    }

    public void action(EnumAction action) {
        switch (action) {
            case MENU_REPRESENTATION: // activation de vuePresence depuis vueMenu
                MenuRepresentation();
                break;
            case MENU_REPRESENTATION_QUITTER:    // retour à vueMenu depuis la vuePresence
                menuQuitterRepresentation();
                break;
            case MENU_QUITTER: // fin de l'application depuis vueMenu
                menuQuitter();
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
        }else{
            //ctrlLesRepresentations.actualiser(); Methode de la classe DaoRepresentation
        }
        ctrlMenu.getVue().setEnabled(false);
        ctrlLesRepresentations.getVue().setEnabled(true);
    }
    
    private void menuQuitterRepresentation(){
        if(ctrlMenu == null){
            ctrlMenu = new CtrlMenu(this);
        }
        ctrlLesRepresentations.getVue().setVisible(false);
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true);
    }
    
}
